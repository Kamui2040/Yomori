# Contributing to Yomori

Contributions are welcome when they preserve Yomori's source-neutral, local-first, extension-compatible product boundaries.

Read, in order:

1. `AGENTS.md`
2. `PROJECT_CONTEXT.md`
3. the relevant documents under `docs/`
4. the affected source, tests, database schema, and build configuration

## Before opening an issue

Use the Yomori issue templates. Do not use Yomori issues to request, recommend, distribute, or troubleshoot a particular content source or extension repository.

Security vulnerabilities must be reported privately through `SECURITY.md`.

## Development requirements

- Android Studio and the repository's documented JDK/Android SDK versions
- Kotlin and Android development experience
- the repository Gradle wrapper
- a representative Android emulator or physical device where the change affects UI, reader behavior, permissions, storage, or extensions

On Windows, common checks are:

```powershell
.\gradlew.bat spotlessCheck
.\gradlew.bat testDebugUnitTest
.\gradlew.bat verifySqlDelightMigration
.\gradlew.bat assemblePreview
git diff --check
```

Run the relevant subset and document anything not run.

## Product and compatibility rules

A contribution must not:

- bundle, recommend, preselect, install, or auto-trust a source, extension, or extension repository;
- rename or break extension-facing `eu.kanade.tachiyomi.source` contracts;
- query a source outside the reading list's visible user-selected source set;
- silently replace confirmed mappings, restore rejected candidates, clear skips, or fall back from an unavailable confirmed source;
- weaken XML parsing limits, request bounds, signature checks, privacy, or telemetry-free behavior;
- add production signing material or private test data;
- re-enable inherited Mihon release, update, support, or website automation.

## Documentation and release impact

Update `PROJECT_CONTEXT.md` when a merged decision, migration, invariant, blocker, or milestone changes.

Release-affecting work must review `docs/RELEASE_READINESS.md`, with F-Droid as the primary FOSS target and the Accrescent security overlay used as the stricter security benchmark.

Store submissions, production signing, identity verification, and publication are separate release operations.

## Pull requests

Keep pull requests focused and independently reviewable. Include:

- the user-visible reason for the change;
- affected compatibility or privacy boundaries;
- tests and local commands run;
- device QA performed or still required;
- migration and backup implications;
- release-readiness impact;
- screenshots for material UI changes.

Yomori is independently maintained and is not a Mihon support channel.
