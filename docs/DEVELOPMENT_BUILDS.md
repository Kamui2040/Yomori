# Development APKs

Yomori development APKs use the dedicated `io.github.kamui2040.yomori.debug` package and the reproducible public development certificate.

In PC mode, build, validate, sign, and verify locally. GitHub Actions are reserved for an explicitly authorized phone workflow where local execution is unavailable.

## Package and signing

- Package: `io.github.kamui2040.yomori.debug`
- Key alias: `yomori-development`
- Test keystore password: `android`
- Test key password: `android`
- Required certificate SHA-256: `08db929c3863a587963a3d72668622c9f464cbb3612cc2f4df29cdcb63750625`
- Telemetry: disabled
- Purpose: development and testing only

The repository source of truth for the intentionally public development key and certificate is:

```text
.github/scripts/create-public-dev-keystore.sh
```

The public development certificate permits an updated `.debug` APK to replace an earlier correctly signed `.debug` APK while retaining its app data. It is intentionally unsuitable for production because anyone can reproduce the public test key.

Never use this key for a production release.

## PC-local build configuration

Generate the public development keystore from the repository source of truth, then create an untracked root-level `keystore.properties` file using an absolute local path:

```properties
storeFile=C:/absolute/path/to/yomori-public-development.p12
storePassword=android
keyAlias=yomori-development
keyPassword=android
```

Do not commit the generated keystore or `keystore.properties`.

Build the preview APKs with the Windows repository wrapper:

```powershell
.\gradlew.bat assemblePreview
```

Local Gradle outputs are written below:

```text
app\build\outputs\apk\preview
```

Select the APK matching the device ABI. Most current Android phones use `arm64-v8a`; the universal APK is larger but supports all packaged ABIs.

## Certificate verification

Before installation, inspect the APK certificate with Android SDK `apksigner` and compare the reported SHA-256 certificate digest with the required Yomori public-development fingerprint.

Do not depend on one signer heading such as `Signer #1`; tool versions may identify the same certificate as `V2 Signer`. Match the stable certificate SHA-256 digest field and print both the actual and expected values before deciding that they match.

Also verify the installed `io.github.kamui2040.yomori.debug` package certificate before an in-place update when there is any uncertainty about its origin.

## In-place installation

After both certificate fingerprints match, install with replacement enabled:

```powershell
adb install -r <path-to-signed-preview-apk>
```

Do not uninstall the development package merely to bypass a signature mismatch when its local data must be preserved. Resolve the signing mismatch instead.

## Authorized phone workflow

When the user explicitly authorizes the phone workflow because local building is unavailable, the configured workflow may produce signed development APK artifacts using the same `.debug` identity and public certificate.

Workflow artifact filenames use:

```text
Yomori-v<version>-build<workflow-run>-<short-sha>-<abi>.apk
```

Local Gradle builds use Android build-tool filenames unless a separate local packaging helper renames them.

## Earlier installations

Earlier Yomori artifacts may use the base package `io.github.kamui2040.yomori` or a different temporary signature. Those installations cannot be replaced by the `.debug` package.

Transfer wanted data through backup and restore before removing an incompatible earlier installation.
