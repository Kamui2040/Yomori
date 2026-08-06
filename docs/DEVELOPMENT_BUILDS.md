# Development APKs

Yomori does not publish development APKs automatically. GitHub Actions is disabled for ordinary development, pull requests, and releases. PC validation builds use the repository Gradle wrapper and remain local unless a separately authorized handoff explicitly publishes an artifact.

The retained manual phone workflow is dormant infrastructure. Do not dispatch, monitor, or rely on it for PC development.

## Package and build type

- Package: `io.github.kamui2040.yomori.debug`
- Gradle task: `assemblePreview`
- Local output directory: `app/build/outputs/apk/preview/`
- Telemetry: disabled in the standard preview configuration
- Purpose: testing only

On Windows, build the current preview artifacts with:

```powershell
.\gradlew.bat assemblePreview
```

The expected Gradle filenames are `app-universal-preview.apk` for the universal APK and `app-<abi>-preview.apk` for ABI-specific APKs. A separately prepared handoff may use a deterministic versioned filename, but no GitHub-hosted development artifact should be assumed to exist.

## Signing boundary

The preview package and signer must be verified before installation or update. Do not assume an arbitrary local `assemblePreview` output uses the canonical public development certificate merely because it has the `.debug` package ID.

The canonical shared development-update path uses the intentionally public test certificate with SHA-256 digest:

```text
08db929c3863a587963a3d72668622c9f464cbb3612cc2f4df29cdcb63750625
```

The repository retains `.github/scripts/create-public-dev-keystore.sh` for explicitly authorized tooling that needs to reproduce this test identity. Generated keystores and local signing properties must not be committed. The public development certificate and key must never be used for production, release, or store artifacts.

## Installation and update safety

Before any ADB installation:

1. run `adb devices -l`;
2. target only the intended authorized serial with `-s`;
3. verify the APK hash, package ID, version, certificate, debuggable state, and requested permissions;
4. verify that the installed package, when present, has a compatible signer and update path;
5. preserve user data and backups.

Do not automatically uninstall, clear application data, or replace a mismatched package after failure. An incompatible package or signer must stop visibly for review.

The `.debug` package is intentionally separate from the production application ID. Do not assume compatibility with older development or CI artifacts; verify their exact package and certificate first. Use user-controlled backup and restore before removing any earlier installation that contains wanted data.
