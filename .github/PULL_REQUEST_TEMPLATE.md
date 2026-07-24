## Summary

-

## Why

-

## Validation

- [ ] `./gradlew.bat spotlessCheck` or the platform-equivalent wrapper command
- [ ] `./gradlew.bat testDebugUnitTest`
- [ ] `./gradlew.bat verifySqlDelightMigration` when persistence is affected
- [ ] `./gradlew.bat assemblePreview` when Android behavior or resources are affected
- [ ] `git diff --check`
- [ ] Relevant physical-device QA is reported, or the remaining device scope is stated explicitly

## Compatibility and product checks

- [ ] No content source or extension repository was bundled, recommended, preselected, installed, or auto-trusted.
- [ ] Extension-facing API compatibility was preserved or the migration is documented.
- [ ] Standard builds remain telemetry-free and local-first.
- [ ] User-confirmed mappings, rejections, skips, and source choices cannot be silently replaced.
- [ ] Network requests remain visible, bounded, and limited to the user's effective source set.
- [ ] Ordinary reader behavior remains unchanged unless explicitly in scope.
- [ ] `PROJECT_CONTEXT.md` was updated when project state or decisions changed.

## Release-readiness impact

- [ ] Not release-affecting
- [ ] `docs/RELEASE_READINESS.md` was reviewed and updated
- [ ] F-Droid source-build, dependency, anti-feature, and metadata impact was assessed
- [ ] Accrescent cleartext, privileged-access, signing, permission, and packaging impact was assessed
- [ ] No production signing, store submission, account registration, or publication occurred

## Screenshots or artifacts

Not applicable unless noted below.
