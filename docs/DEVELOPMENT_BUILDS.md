# Development APKs

Yomori development APKs use the dedicated `io.github.kamui2040.yomori.debug` package and the reproducible public development certificate.

GitHub Actions is disabled. PC mode builds, validates, signs, and verifies locally. The retained workflow is dormant manual phone-workflow infrastructure only and must not be enabled for ordinary PC development or release publication.

## Package and signing

- Package: `io.github.kamui2040.yomori.debug`
- Key alias: `yomori-development`
- Public test keystore password: `android`
- Public test key password: `android`
- Required certificate SHA-256: `08db929c3863a587963a3d72668622c9f464cbb3612cc2f4df29cdcb63750625`
- Telemetry: disabled
- Purpose: development and testing only

The repository source of truth is `.github/scripts/create-public-dev-keystore.sh`. It contains an intentionally public test key that is valid only for the `.debug` application ID.

## Local generation

Use Git Bash or WSL:

```sh
.github/scripts/create-public-dev-keystore.sh "$HOME/.yomori/signing/yomori-public-development.p12"
```

Create an ignored `keystore.properties` that points to that file, then build with the repository wrapper.

## Local validation

```powershell
.\gradlew.bat spotlessCheck
.\gradlew.bat testDebugUnitTest
.\gradlew.bat verifySqlDelightMigration
.\gradlew.bat assemblePreview
git diff --check
```

Verify every preview APK with the Android SDK `apksigner` and confirm the required SHA-256 certificate.

## Restrictions

- Never use this certificate for `io.github.kamui2040.yomori`.
- Never describe a preview APK as a production or store release.
- Never upload private signing keys or replace the public-development identity with a production identity.
- Production signing, release packaging, source tags, checksums, and store submissions require the separate release-readiness process.
