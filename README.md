# Yomori

[![License: Apache-2.0](https://img.shields.io/github/license/Kamui2040/Yomori)](./LICENSE)

Yomori is a source-agnostic Android comic reader for imported Comic Book Lover (`.cbl`) reading orders. It is an independent Apache-2.0 fork of [Mihon](https://github.com/mihonapp/mihon) and is not endorsed by the Mihon project.

Yomori is in early development. There is no public production release yet.

## What Yomori does

1. Import a local `.cbl` reading order.
2. Select and rank installed Mihon/Tachiyomi-compatible online sources for that list.
3. Search only those selected sources.
4. Automatically accept results that pass every title, issue, confidence, and ambiguity safety gate.
5. Review, confirm, reject, skip, or repair uncertain entries explicitly.
6. Read the persisted CBL order continuously across series and selected sources.

## Source neutrality and user control

- Yomori bundles no content source, extension, or extension repository.
- Yomori does not recommend, preselect, auto-install, or auto-trust sources or extensions.
- Extensions remain separate user-installed APKs and are treated as untrusted executable code.
- User-confirmed mappings, rejections, skips, and source choices are not silently replaced.
- Missing or unavailable sources remain visible instead of triggering hidden fallback.
- Candidate searches are explicit, bounded, and limited to the reading list's selected sources.

## Privacy

Standard Yomori builds are telemetry-free and local-first. Yomori has no central content or matching service. Network traffic occurs only for user-selected third-party extensions, explicitly configured tracking services, or other user-initiated external features.

See [PRIVACY.md](./PRIVACY.md) for the current pre-release privacy statement.

## Development and validation

GitHub Actions is disabled for this repository. PC development uses the repository Gradle wrapper, local preview builds, the public development certificate for `io.github.kamui2040.yomori.debug`, certificate verification, and documented physical-device QA.

Common Windows commands:

```powershell
.\gradlew.bat spotlessCheck
.\gradlew.bat testDebugUnitTest
.\gradlew.bat verifySqlDelightMigration
.\gradlew.bat assemblePreview
git diff --check
```

The public development certificate is for testing only and must never sign production releases.

## Publication targets

Yomori's primary open-source publication target is F-Droid. Release work also follows the Accrescent security baseline and prepares only the minimum packaging or metadata adaptations needed for selected secondary stores.

Current readiness and blockers are tracked in [docs/RELEASE_READINESS.md](./docs/RELEASE_READINESS.md). No store submission or public APK release is ready.

## Documentation

- [PROJECT_CONTEXT.md](./PROJECT_CONTEXT.md) — canonical repository status and decisions.
- [docs/README.md](./docs/README.md) — documentation index.
- [SECURITY.md](./SECURITY.md) — private vulnerability reporting.
- [SUPPORT.md](./SUPPORT.md) — issue scope and support routes.
- [CONTRIBUTING.md](./CONTRIBUTING.md) — contribution requirements.
- [CHANGELOG.md](./CHANGELOG.md) — project and preserved upstream history.

## Support development

Optional support is available through [Ko-fi](https://ko-fi.com/k2040). Donations do not unlock features or create entitlements.

The approved K2040 developer avatar is reserved for a future About section. It is not currently bundled in the application; its release licensing and attribution are tracked in [docs/ABOUT.md](./docs/ABOUT.md) and [docs/ASSET_ATTRIBUTION.md](./docs/ASSET_ATTRIBUTION.md).

## Content disclaimer

Yomori hosts zero content and is not affiliated with third-party content providers, extension repositories, or extension maintainers. Users are responsible for the repositories, extensions, and services they choose and for complying with applicable law and service terms.

## Upstream and attribution

Yomori is derived from Mihon and the earlier Tachiyomi project. Compatibility namespaces remain where required for user-installed extensions and tracker OAuth registrations.

Upstream: [mihonapp/mihon](https://github.com/mihonapp/mihon)

## License

Yomori is licensed under [Apache License 2.0](./LICENSE). Upstream copyright and licence notices must be preserved.
