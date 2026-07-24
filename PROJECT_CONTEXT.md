# Yomori Project Context

## Status

Yomori is in early implementation. It is based on the current `main` branch of `mihonapp/mihon` and will remain compatible with the existing user-installed Mihon/Tachiyomi extension ecosystem.

GitHub Actions is disabled for the repository as of 2026-07-24. PC work uses local Gradle wrapper builds, tests, public-development signing, certificate verification, and documented physical-device QA. Do not re-enable or rely on GitHub Actions unless a future task explicitly authorizes it.

The Android application identity is `io.github.kamui2040.yomori`, with Yomori version line `0.1.0-alpha01`. The Kotlin namespace and extension-facing API packages remain unchanged for compatibility.

Device-test artifacts use the dedicated `io.github.kamui2040.yomori.debug` package and a reproducible public development certificate. Correctly signed local PC builds can update the installed development package in place without removing its local data.

The first product milestone is CBL reading-list import and deterministic, user-correctable matching. The safe parser, transactional persistence, normalization, confidence scoring, visible import interface, per-list source-selection flow, candidate-resolution storage, rejection history, entry overrides, series mappings, confirmation-protected repository operations, explicit candidate-search orchestration, and persisted manual-review interface are implemented and covered by focused tests. Cross-series reader navigation and list-specific progress are implemented on draft PR #15 and have passed first-entry, next/previous, resume, and ordinary-reader device checks. No public Yomori release is ready.

## Current unmerged work and approved follow-ups

- Draft PR #15 contains cross-series reader navigation and list-specific progress. Its current head includes merged PR #17 with the corrected Reading Lists layout, explicit candidate-search cancellation, and defensive search teardown.
- Physical-device QA passed for exact first-entry opening, cross-series next and previous navigation, persisted resume on the second entry, selected-source preservation, ordinary page navigation, and ordinary-reader isolation.
- Remaining PR #15 device QA covers completed-list restart, final-list completion, unresolved Review/Skip/Stop behavior, unavailable-source handling, and any final narrow-screen or accessibility observations.
- The Reading Lists overview uses a two-row structure: a full-width title and status row followed by direct Read or Resume, Review, Search for matches, Edit sources, and Delete actions. Candidate-search progress remains visible and can be cancelled explicitly.
- The local branch `agent/reading-list-settings-matching-preserved` contains separate settings and matching follow-up work. It must remain preserved and must not be folded into PR #15.
- The current merged matching implementation still uses the documented confidence threshold and ambiguity margin. Approved follow-up behavior is to select the strongest candidate when every safety gate passes and resolve exact score ties through effective source priority followed by stable candidate identity or rank. This follow-up must not be described as implemented until its code and tests land.
- Planned product follow-ups include reusable reading-source settings, ordered global and category source defaults, reading-list categories, explicit optional main-library integration, manual search, and repair and rematching tools.

## Product goal

Yomori is a source-agnostic Android comic reader that imports Comic Book Lover (`.cbl`) reading lists, resolves their entries through user-selected compatible extensions, and reads the resulting cross-series order as one continuous list.

Yomori does not provide, bundle, host, operate, or recommend content sources.

## Confirmed decisions

- App and repository name: **Yomori**.
- Canonical repository: `Kamui2040/Yomori`.
- Android application ID: `io.github.kamui2040.yomori`.
- Development application ID: `io.github.kamui2040.yomori.debug`.
- Base project: Mihon under Apache-2.0.
- Extensions remain separate user-installed APKs.
- Users add extension repositories and choose which installed extensions a CBL may search.
- Matching is series-first, then issue/chapter matching.
- Matching uses a configurable confidence percentage plus an ambiguity margin between the best and second-best candidates.
- Low-confidence or ambiguous results require user review.
- Users may set source preferences globally, per reading list, per series, and per individual entry.
- User-confirmed mappings override automatic matches and are never silently replaced.
- Original CBL data is retained even after successful matching.
- CBL parsing preserves `<Book>` order and rejects DTD/entity declarations, oversized documents, excessive entry counts, malformed structure, and entries without required `Series` or `Number` attributes.
- Imported lists, entries, ordered database references, unknown metadata, warnings, matching state, and reading-list progress are stored in SQLDelight.
- SQLDelight migration 15 adds ordered per-list source selections without changing extension-facing APIs.
- SQLDelight migration 16 adds ranked candidate snapshots, rejection history, entry overrides, and list-local series mappings without changing extension-facing APIs.
- Candidate refresh and automatic resolution are transactional and refuse to modify user-confirmed entry mappings.
- Candidate refresh and automatic resolution refuse skipped entries; only explicit confirmation may clear a skip when the user selects a match.
- Automatic series mapping cannot replace a user-confirmed series mapping; only an explicit confirmation or removal may change it.
- Candidate rejections persist independently from candidate refreshes and are excluded from later automatic matching until explicitly cleared or confirmed.
- Candidate searches run only after an explicit user action and query only the installed online sources selected for that reading list.
- Search work is grouped by normalized title plus known year and volume, uses one first-page series search per selected source and series, fetches each source/series issue list at most once per operation, shares a three-request concurrency limit across simultaneous list searches, and applies a 30-second timeout to each extension request.
- Entry overrides constrain candidate search before lower-priority series and reading-list preferences; unavailable override sources are not silently bypassed.
- Search results are bounded before persistence, are never added to the normal library, and are saved with the existing score breakdown and confirmation protection. Rejected candidates remain persisted for review but do not participate in automatic decisions.
- Confirmed and skipped entries are not searched automatically; missing selected sources are reported without blocking available selected sources.
- A user-confirmed series mapping is never bypassed by replacement searches when its selected source is unavailable.
- Each reading list exposes a dedicated manual-review screen that reads only persisted list and resolution data. Opening or browsing it performs no source search or extension network request.
- Manual review preserves original CBL order and keeps ambiguous, unresolved, unavailable, automatically matched, user-confirmed, skipped, and removed-candidate states visible.
- Candidate review shows confidence, lead, decision reason, source and language, remote identities, complete score evidence, conflicts, rejection state, overrides, and series mappings.
- Entry confirmation, candidate rejection or restoration, and series-mapping confirmation or removal are separate explicit actions. Each successful action is persisted immediately and the screen reloads repository data.
- Rejected candidates that are no longer returned by a source remain visible through their persisted rejection record and can be restored explicitly.
- Reading-list insertion is transactional, deletion cascades to owned records, and progress cannot point to a missing entry.
- The primary Reading Lists tab imports local `.cbl` documents through Android's system document picker.
- Imported files are read with a 16 MiB boundary and support UTF-8, UTF-16 little-endian, and UTF-16 big-endian XML.
- At least one currently installed online source must be selected before a reading list can be saved.
- Selected source order is persisted as the list's search-priority order and can be edited later.
- Missing extension IDs remain visible as unavailable source choices for later repair rather than being silently discarded.
- No source is bundled, recommended, or selected automatically.
- Title normalization produces locale-independent full and edition-free comparison keys while retaining extracted year and volume as separate scoring evidence.
- Issue-number normalization preserves annual, special, Free Comic Book Day, one-shot, suffix, decimal, fraction, and opaque identifier distinctions.
- Normalization never replaces the original CBL metadata stored for repair and rematching.
- Confidence scoring exposes a complete component breakdown for title, issue, year, volume, external identifiers, source preferences, and confirmed history.
- Automatic matching requires at least 88%, an equivalent issue number, at least 85% title similarity, and a lead of at least 10 percentage points over the runner-up.
- Scores from 65% through 87.99% require review; scores below 65% remain unresolved.
- Missing optional metadata is neutral, conflicting metadata is penalized, and supporting evidence cannot bypass title or issue safety gates.
- Equal high-scoring candidates remain ambiguous rather than being silently selected by source order.
- F-Droid is the primary open-source publication target.
- Accrescent's technical requirements are the security hardening overlay even while new-app onboarding is closed.
- Store-specific work should use one common compliant release candidate with only minimal packaging or metadata adaptations.
- Every release-readiness requirement is classified as PASS, PARTIAL, BLOCKED, or NOT APPLICABLE in `docs/RELEASE_READINESS.md`.
- The optional developer-support URL is `https://ko-fi.com/k2040` and must not unlock features or create entitlements.
- The approved K2040 wolf avatar is reserved for a future About section. It remains in shared Google Drive assets and is not yet bundled because a repository redistribution licence entry is still required.
- Standard Yomori builds do not include telemetry.
- PC development uses local Gradle wrapper validation, public-development signing, and certificate verification while GitHub Actions remains disabled.
- Local Gradle outputs retain Android build-tool filenames until a dedicated local packaging helper is added.
- Development APKs use a public test certificate that is never used for production releases.
- Null-pointer failures returned by HTTP source extensions are shown as an actionable update-or-change-source message instead of a raw exception.
- Inherited public release automation remains disabled until Yomori production signing and release readiness are established.

## Publication and store-readiness status

The governing shared standard is **Android App Store Release Readiness Standard** (`1LBaEQairLGcE6NpY4wv6hoFFiFVOfJbWadUabgCseHg`).

Current baseline:

- F-Droid: **BLOCKED** pending a clean source-build recipe, complete dependency and asset licence audit, Fastlane metadata, anti-feature decisions, and an F-Droid-safe answer for self-update and executable extension-package behavior.
- Accrescent overlay: **BLOCKED** by global cleartext allowance, Shizuku integration, package-installation permissions, production signing, and missing `.apks` packaging.
- Direct forge, Obtainium, OpenAPK, and Komi: **BLOCKED** until production signing, deterministic release assets, source tags, checksums, metadata, and public release approval exist.
- IzzyOnDroid: **BLOCKED** by the general release blockers plus the need for direct clarification of its generative-AI eligibility policy.
- Uptodown and APKPure: **BLOCKED** until a signed release, complete listing metadata, ownership verification, and post-download artifact checks are ready.
- Huawei AppGallery and Xiaomi GetApps: **BLOCKED** pending production readiness, identity and seller-data review, live-console verification, and representative OEM-device QA.
- Aptoide: **NOT APPLICABLE** while the shared standard excludes it because of the current paid-submission requirement.

The detailed evidence and smallest compliant changes are maintained in `docs/RELEASE_READINESS.md`.

## Matching defaults

Initial defaults, subject to testing with real imported lists:

- Automatic acceptance: score at least 88%.
- Review range: 65% through 87.99%.
- Unresolved: below 65%.
- Required lead over the second candidate: 10 percentage points.
- Minimum title similarity for automatic acceptance: 85%.

The basic score combines normalized series-title similarity, issue-number equivalence, volume/year agreement, external identifiers, source preference, and confirmed user history. The complete score breakdown is retained for the manual-review interface.

## Source preference hierarchy

From highest to lowest priority:

1. Entry-specific confirmed match or source override.
2. Series-specific confirmed mapping or source preference.
3. Reading-list source order.
4. Global source preference.

Only user-selected installed extensions may be queried for a reading list.

## Resolution states

Persisted states:

- `UNSEARCHED`
- `SEARCHING`
- `AUTO_MATCHED`
- `USER_CONFIRMED`
- `AMBIGUOUS`
- `UNRESOLVED`
- `SOURCE_UNAVAILABLE`
- `CHAPTER_REMOVED`
- `NEEDS_REMATCH`

## Initial implementation sequence

1. Repository governance and CI adaptation. **Complete.**
2. Independent application identity and temporary Yomori branding. **Complete.**
3. CBL domain model and parser with fixtures and unit tests. **Complete.**
4. Reading-list persistence and migrations. **Complete.**
5. Title and issue normalization. **Complete.**
6. Confidence scoring and ambiguity rules. **Complete.**
7. Import and source-selection flow. **Complete.**
8. Candidate persistence, rejection history, and protected manual overrides. **Complete.**
9. Candidate search orchestration. **Complete.**
10. Manual-review UI. **Complete.**
11. Cross-series reader navigation and progress. **Implemented on draft PR #15; not merged to `main`.**
12. Repair and rematching tools.

## Compatibility invariants

- Keep extension-facing APIs binary compatible, particularly the `eu.kanade.tachiyomi.source` contracts.
- Do not rename those API packages as part of product rebranding.
- Keep extension signature verification and trust handling.
- Track upstream source-API versions and extension-loader changes.

## Release blockers

Before the first public APK or store submission:

- Resolve every required `BLOCKED` item in `docs/RELEASE_READINESS.md`.
- Complete the code, dependency, prebuilt-binary, translation, font, image, sound, and other asset licence audit.
- Finalize original Yomori visual branding beyond the temporary launcher mark.
- Remove or replace inherited Mihon-specific update, support, download, and website endpoints.
- Establish a clean F-Droid-compatible source build and decide the F-Droid treatment of executable extension installation, external repositories, self-update behavior, and anti-features.
- Remove or isolate global cleartext, Shizuku, package-installation, and other Accrescent-incompatible behavior from any Accrescent-targeted production package.
- Establish protected Yomori production signing, certificate continuity, key custody, release versioning, checksums, and source tags.
- Validate extension loading against representative compatible extensions without bundling or recommending any source.
- Complete backup/restore, permission, offline, accessibility, localization, supported-version, screen-size, and representative device QA.
- Publish stable privacy, security, support, licence, attribution, changelog, donation, and store-metadata routes.
- Prepare Fastlane-compatible metadata, licensed icons, screenshots, feature graphics where required, descriptions, content ratings, declarations, and release notes.
- Recheck live official store requirements before registration or submission.

## Upstream baseline

Fork baseline at project creation:

- Upstream commit: `b4635c41a8dd5e30edf480b0c9bdc80d0fda0520`
- Upstream release line: Mihon `0.20.1`
- Baseline date: 2026-07-10
