# Yomori Release Readiness

Audit basis: shared Google Drive document **Android App Store Release Readiness Standard**.

- Standard ID: `1LBaEQairLGcE6NpY4wv6hoFFiFVOfJbWadUabgCseHg`
- Standard URL: https://docs.google.com/document/d/1LBaEQairLGcE6NpY4wv6hoFFiFVOfJbWadUabgCseHg/edit
- Primary target: F-Droid
- Security overlay: Accrescent
- Application ID: `io.github.kamui2040.yomori`
- Development ID: `io.github.kamui2040.yomori.debug`
- Current version line: `0.1.0-alpha01`
- Current versionCode: `1`
- Minimum SDK: `26`
- Target SDK: `36`
- Audit source branch before this documentation update: `agent/cross-series-reader-navigation`
- Audit source commit: `f66c57c25787c4ff358d1101e8068524e8dcf196`
- Public release tag: none
- Production certificate: not established

Statuses are `PASS`, `PARTIAL`, `BLOCKED`, or `NOT APPLICABLE`. A required blocked item prevents submission.

## 1. Open source and ownership

| Requirement | Status | Evidence or missing work |
|---|---|---|
| Complete preferred source is public | PASS | `Kamui2040/Yomori` is public and canonical. |
| Compatible software licence | PASS | Root `LICENSE` is Apache-2.0. |
| Upstream attribution | PASS | `README.md`, `UPSTREAM.md`, and preserved upstream history identify Mihon/Tachiyomi derivation and non-affiliation. |
| Distinct public identity | PARTIAL | Yomori name, launcher mark, and package IDs exist; inherited internal names, themes, links, and release-facing resources still need audit. |
| Code and asset licence inventory | BLOCKED | Dependency, prebuilt binary, translation, font, image, sound, and store-artwork audit is incomplete. See `ASSET_ATTRIBUTION.md`. |
| Public history secret review | PARTIAL | No secret was identified in this documentation audit; complete history scanning and release review remain required. |
| Matching source tag for every release | NOT APPLICABLE | No public Yomori release exists. |
| Maintained end-user functionality | PARTIAL | Core import/matching/review exists and reader work is on PR #15; first production release remains incomplete. |
| Public purpose, limitations, build, privacy, support | PASS | `README.md`, `PRIVACY.md`, `SUPPORT.md`, and `CONTRIBUTING.md`. |

## 2. Build, dependencies, and reproducibility

| Requirement | Status | Evidence or missing work |
|---|---|---|
| Clean checkout without private services | PARTIAL | Local branch builds passed; a clean tagged release/F-Droid build has not been reproduced. |
| Documented and pinned toolchain | PASS | `gradle/mihon.versions.toml`, `.github/.java-version`, Gradle wrapper, and version catalog pin the primary toolchain. |
| Unsigned or store-signable production build | BLOCKED | Release build currently inherits debug signing behavior; production/store-signable path is not established. |
| Signing separation and key custody | BLOCKED | Public development signing is separated by package, but production identity and custody do not exist. |
| Dependency and licence audit | BLOCKED | Version catalog exists; licence, provenance, prebuilt, JitPack, and transitive dependency audit is incomplete. |
| No proprietary runtime SDK in F-Droid variant | PARTIAL | Standard builds are telemetry-free; exact F-Droid dependency graph and variant behavior require proof. |
| No Firebase/Play/Crashlytics in F-Droid variant | PARTIAL | Telemetry configuration is disabled for standard builds; inspect the final F-Droid dependency graph and APK. |
| Avoid unverified prebuilt binaries | PARTIAL | Native and JitPack dependencies require provenance and licence verification. |
| Reproducible build | BLOCKED | Timestamps/build-time fields, ordering, native dependencies, signing, and byte-for-byte reproduction are unverified. |
| Deterministic local release commands | PARTIAL | Preview checks are documented; lint, F-Droid assembly, package inspection, checksum, and release-record commands remain to be added. |
| Final non-debuggable production APK | BLOCKED | No production release candidate exists. |

## 3. Security and privacy

| Requirement | Status | Evidence or missing work |
|---|---|---|
| Minimal permissions | PARTIAL | Manifest includes network, storage, battery, package installation/deletion/update, package query, notifications, and foreground-service permissions; each needs release-variant justification. |
| Denial, revocation, and recovery tests | BLOCKED | Representative permission-path QA is not complete. |
| Cleartext disabled | BLOCKED | `network_security_config.xml` globally permits cleartext and user-added CAs. |
| No hidden telemetry, ads, or automatic crash reporting | PASS | Standard builds are documented and locally validated as telemetry-free; reverify exact production artifact. |
| Data lifecycle documented | PASS | `PRIVACY.md` documents local data, network, backup, deletion, and external services. |
| Sensitive data storage and logging review | PARTIAL | Architecture forbids sensitive logging; artifact and code-path review remain. |
| No root, ADB, or Shizuku | BLOCKED | Shizuku dependencies and exported provider exist; incompatible with the Accrescent baseline. |
| No self-updater or external executable download | BLOCKED | Inherited updater and extension-package behavior require removal or store-specific variant isolation. |
| `REQUEST_INSTALL_PACKAGES` absent or justified | BLOCKED | Permission exists; core-function and per-store acceptance review is required. |
| Exported components minimized | PARTIAL | Manifest review is incomplete for exported activities/providers, OAuth schemes, deep links, file handling, and external intents. |
| WebView, deep link, file-sharing, and network abuse review | PARTIAL | Architecture exists; complete implementation and penetration review remain. |
| Private security-reporting route | PARTIAL | `SECURITY.md` points to GitHub private vulnerability reporting; verify repository feature availability before release. |
| Privacy policy | PASS | `PRIVACY.md` exists; claims still require exact production-artifact verification. |

## 4. Package, signing, and versioning

| Requirement | Status | Evidence or missing work |
|---|---|---|
| Unique permanent application ID | PASS | `io.github.kamui2040.yomori`. |
| Domain control evidence | PARTIAL | GitHub namespace is controlled; DNS/domain proof for stores such as Accrescent is not established. |
| Long-lived production signer | BLOCKED | Not created or documented. |
| Modern production signature scheme | BLOCKED | Only development certificate verification has been completed. |
| Debug certificate excluded from production | BLOCKED | Release signing configuration must be redesigned and verified. |
| Version and certificate release record | PARTIAL | Current values are documented; no production certificate or release record exists. |
| Current target SDK | PASS | Target SDK 36 at audit time; recheck live store requirements immediately before submission. |
| ABI pairing | PASS | Build configuration includes `armeabi-v7a`/`arm64-v8a` and `x86`/`x86_64`, plus universal output. |
| Store-specific APK/AAB/APKS outputs | PARTIAL | Preview APKs exist; production APK, AAB, and Accrescent `.apks` paths are not established. |
| Developer identity and package registration | BLOCKED | Manual store and Android developer verification work has not begun. |
| Release checksums | BLOCKED | No public release assets exist. |

## 5. Functional quality and compatibility

| Requirement | Status | Evidence or missing work |
|---|---|---|
| Advertised features in release build | PARTIAL | No release build; current feature branch has passed selected reader QA. |
| Unit, migration, format, and assembly checks | PASS | Local `spotlessCheck`, `testDebugUnitTest`, `verifySqlDelightMigration`, `assemblePreview`, and certificate checks passed before this documentation-only change. |
| Install, clean launch, update, uninstall, reinstall | PARTIAL | Fresh install, launch, backup restore, and development update path were exercised; uninstall/reinstall and production update remain. |
| Migration and backup compatibility | PARTIAL | SQLDelight checks pass; cross-version public backup migration is untested. |
| Permission QA | BLOCKED | Grant/deny/revoke/recovery matrix is incomplete. |
| Offline and failure behavior | PARTIAL | Matching failure handling is designed and partly tested; release-wide offline QA is incomplete. |
| Android versions and screen sizes | PARTIAL | Representative phone testing exists; supported-version and size matrix is incomplete. |
| Accessibility, scaling, dark mode, localization, RTL | PARTIAL | Architecture requirements exist; comprehensive device review is incomplete. |
| Background work, notifications, battery | PARTIAL | Manifest features exist; complete functional and battery QA is incomplete. |
| Huawei and Xiaomi devices | BLOCKED | Required before OEM-store submission. |
| No crashes, placeholders, test endpoints, debug menus | PARTIAL | Selected flows passed; production-artifact audit is incomplete. |
| Store-delivered artifact verification | NOT APPLICABLE | No publication exists. |

## 6. Metadata, legal, and public URLs

| Requirement | Status | Evidence or missing work |
|---|---|---|
| Name, descriptions, category, feature summary | PARTIAL | README text exists; store-ready localized metadata is absent. |
| High-resolution store icon | PARTIAL | Temporary Yomori launcher mark exists; final licensed store icon is not approved. |
| Screenshots | BLOCKED | Current release screenshots are absent. |
| Feature graphic or banner | BLOCKED | Not prepared. |
| Release notes and changelog | PARTIAL | `CHANGELOG.md` exists; first-release notes are absent. |
| Languages, countries, age, rating, accessibility | BLOCKED | Store declarations are not prepared. |
| Stable privacy/source/licence/support/security/donation URLs | PARTIAL | Repository documents and Ko-fi exist; public release URLs and long-term hosting must be verified. |
| Advertising, analytics, accounts, purchases, data, Internet declarations | BLOCKED | Store-specific declarations are not prepared. |
| Trademark, copyright, attribution, non-affiliation | PARTIAL | Core wording exists; complete modified-file and asset notices remain. |
| Sensitive-purpose disclaimers | NOT APPLICABLE | Yomori is not a health, finance, location, or security-purpose app; content/source disclaimer still applies. |
| Optional donations do not unlock features | PASS | Ko-fi is documented as optional with no entitlements. |
| Public seller details | BLOCKED | Manual identity and privacy review is required before registration. |
| Fastlane metadata | BLOCKED | No complete Fastlane-compatible metadata tree exists. |

## 7. Canonical release layout

All items are currently **BLOCKED** or **NOT APPLICABLE** because Yomori has no production signer, release tag, signed public APK, deterministic release asset set, published checksums, certificate record, or release history.

## 8. F-Droid baseline

| Requirement | Status | Missing work |
|---|---|---|
| Genuine FLOSS source and licensed assets | PARTIAL | Apache source is public; complete asset/dependency audit is blocked. |
| F-Droid source build | BLOCKED | Add and verify the F-Droid build recipe from a clean public tag. |
| No proprietary SDK or non-free dependency | PARTIAL | Exact F-Droid dependency and APK audit required. |
| No private credentials or infrastructure | PASS | Intended build does not require production signing; prove with clean recipe. |
| Unique ID and useful functionality | PASS | Package is unique and core workflow is functional. |
| Honest anti-features | BLOCKED | Decide and document extension installation, external network, tracker, and any non-free network-service anti-features. |
| No self-updater or executable-download behavior | BLOCKED | Remove or isolate prohibited behavior from F-Droid variant. |
| Fastlane metadata and assets | BLOCKED | Not prepared. |
| Donation and ownership verification | PASS | Repository owner and Ko-fi route are documented. |
| Maintained after acceptance | PARTIAL | Project is active but pre-release. |
| Reproducible upstream signing | BLOCKED | Not established; normal F-Droid signing remains acceptable if chosen. |

## 9. Accrescent overlay

| Requirement | Status | Missing work |
|---|---|---|
| Current target SDK | PASS | Target 36 at audit time; live recheck required. |
| Non-debuggable production artifact | BLOCKED | None exists. |
| Cleartext disabled | BLOCKED | Global cleartext is enabled. |
| Production signer and modern scheme | BLOCKED | Not established. |
| Single signer | BLOCKED | Not established. |
| ABI pairing | PASS | Supported pairs are configured. |
| No Shizuku/root/ADB | BLOCKED | Shizuku is present. |
| No updater or external prompt | BLOCKED | Inherited behavior requires removal or isolation. |
| Minimized permissions | BLOCKED | Package-management and query permissions require redesign/review. |
| `.apks` set | BLOCKED | No bundletool pipeline. |
| 512×512 icon | PARTIAL | Final licensed icon not approved. |
| Domain proof | BLOCKED | Not established. |
| Size limit | NOT APPLICABLE | Recheck when an actual submission candidate exists. |

## 10. Store eligibility

| Channel | Status | Minimum remaining adaptation |
|---|---|---|
| F-Droid | BLOCKED | Resolve FOSS build, dependency/assets, anti-features, updater/executable downloads, and metadata. |
| GitHub/forge + Obtainium | BLOCKED | Production signing, deterministic APK names, tags, checksums, certificate continuity, and release notes. |
| OpenAPK | BLOCKED | Public signed release APK and current repository metadata. |
| Komi Store | BLOCKED | Discoverable public signed APK release, README, licence, and deterministic assets. |
| IzzyOnDroid | BLOCKED | General release blockers, cleartext/size review, metadata, and direct clarification of generative-AI eligibility. |
| Uptodown | BLOCKED | Signed APK, complete metadata, ownership, review, and post-download verification. |
| APKPure | BLOCKED | Signed APK/XAPK, Developer Console ownership, live requirements, and artifact verification. |
| Huawei AppGallery | BLOCKED | Production release, identity/privacy review, localized metadata, and Huawei-device QA without assuming GMS. |
| Xiaomi GetApps | BLOCKED | Production release, live Global Developer console verification, seller-data review, regional eligibility, and Xiaomi-device QA. |
| Accrescent | BLOCKED | Onboarding closed plus all security-overlay blockers. |
| SafeHaven | PARTIAL | Hold as experimental; recheck build, tracker, provenance, and verification policies later. |
| Orion Store | NOT APPLICABLE | Hold unless a separate trust and brand-risk review approves it. |
| Aptoide | NOT APPLICABLE | Excluded while the shared standard records the paid submission requirement. |

## Smallest compliant next changes

1. Complete dependency, prebuilt binary, translation, and asset licence inventories.
2. Define and verify a clean F-Droid build variant and recipe.
3. Remove or isolate self-update, executable extension installation, and non-compliant external-download behavior per target store.
4. Design an Accrescent-compatible production variant without global cleartext, Shizuku, or unreviewed package permissions.
5. Establish protected production signing and deterministic release records.
6. Prepare Fastlane metadata, licensed final artwork, screenshots, descriptions, declarations, and release notes.
7. Complete the release QA matrix.
8. Recheck each selected store's live official policy before any account or submission action.

No publication, store registration, identity upload, or production signing was performed by this documentation update.
