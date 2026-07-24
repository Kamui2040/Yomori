# Decision Log

## 2026-07-10 — Base Yomori on Mihon

Yomori uses Mihon as its upstream base to retain a mature Android reader, downloader, library, and compatible extension architecture.

Compatibility namespaces and OAuth schemes may retain inherited names where changing them would break user-installed extensions or registered integrations. Public product identity remains Yomori and must not imply Mihon endorsement.

## 2026-07-10 — Remain source-agnostic

Yomori will not bundle, operate, maintain, recommend, preselect, auto-install, or auto-trust content sources or extension repositories. Installed extensions and matching scope remain user-controlled.

## 2026-07-10 — Use confidence plus ambiguity margin

Automatic CBL matching requires the documented safety gates, confidence threshold, and ambiguity evidence. User-confirmed choices remain authoritative.

## 2026-07-10 — Keep user confirmation authoritative

A user-confirmed series or issue mapping cannot be silently replaced by later automatic matching.

## 2026-07-10 — Build without telemetry

Standard Yomori builds are telemetry-free. PC validation uses local repository-wrapper commands, public-development signing for the `.debug` package, certificate verification, and documented device QA. GitHub Actions is disabled.

## 2026-07-24 — Target F-Droid first

F-Droid is Yomori's primary open-source publication target. The project follows the shared **Android App Store Release Readiness Standard** and treats Accrescent's technical requirements as the security hardening overlay.

Every release-readiness item is classified as PASS, PARTIAL, BLOCKED, or NOT APPLICABLE in `RELEASE_READINESS.md`. Store-specific work must not weaken source neutrality, extension compatibility, privacy, or the F-Droid build.

## 2026-07-24 — Keep production signing separate

The public development certificate is limited to `io.github.kamui2040.yomori.debug`. Production signing, key custody, store registration, identity verification, and publication are separate controlled release operations.

## 2026-07-24 — Optional developer support

The optional developer-support route is https://ko-fi.com/k2040. Donations do not unlock functionality or create entitlements.

The approved K2040 wolf avatar is planned for a future About section, but it remains outside the repository and APK until a redistribution-compatible licence is recorded.
