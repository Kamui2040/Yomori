# Yomori Project Context

## Status

Yomori is an early-development, source-agnostic Android comic reader based on Mihon. The canonical merged state is the public `main` branch of `Kamui2040/Yomori`.

GitHub Actions is disabled for the repository as of 2026-07-24. PC development uses local Gradle-wrapper checks, local preview assembly, the reproducible public development certificate, certificate verification, and documented physical-device QA. Do not re-enable, trigger, monitor, or rely on Actions unless a future phone-only workflow is explicitly authorized.

The production application ID is `io.github.kamui2040.yomori`; development-device artifacts use `io.github.kamui2040.yomori.debug`. The Yomori version line is `0.1.0-alpha01`. Extension-facing Mihon/Tachiyomi namespaces remain unchanged where compatibility requires them.

Merged `main` implements safe CBL parsing, transactional persistence, normalization and scoring, visible source selection, bounded candidate search, protected automatic resolution, persisted rejection/override/mapping state, and manual review.

Draft PR #15 (`agent/cross-series-reader-navigation`) implements cross-series navigation and list-specific reading progress. It is open, draft, unmerged, and not release-ready. Its current head is `e496094ba7560095bc9c06c1e8b75be0a58ce8fc`; PR #17 is incorporated only into that branch. Physical-device QA still proves a blocker: an already matched entry can remain readable after its exact extension is disabled in Android settings, including after force-stop and cold restart. Do not merge PR #15 or describe the disabled-source requirement as passed until that behavior is corrected and retested. Do not clear confirmed mappings or cached rows merely to conceal the defect.

No public production release, production signing identity, store submission, accepted F-Droid build, or reproducibility result exists.

## Product goal

Yomori imports Comic Book Lover (`.cbl`) reading lists, resolves entries through explicitly selected compatible extensions, and reads the resulting order continuously across series and selected sources.

Yomori does not provide, bundle, host, operate, recommend, preselect, install, or trust content sources or extension repositories. It is independently maintained and must not imply Mihon endorsement.

## Authority and evidence

- `AGENTS.md` owns stable repository policy.
- This file owns mutable merged status, decisions, thresholds, blockers, active pull requests, validation state, and release readiness.
- Focused documents under `docs/` own detailed architecture and release evidence.
- Open branches and Drive records are evidence, not merged truth.
- Source, tests, build configuration, package metadata, APK inspection, and physical-device evidence own their specific facts.

## Confirmed merged decisions

- Canonical repository: `Kamui2040/Yomori`; stable branch: `main`; upstream: `mihonapp/mihon`; licence: Apache-2.0.
- Extensions remain separate user-installed APKs and are treated as untrusted executable code.
- Users explicitly choose the installed online sources that each reading list may query.
- CBL parsing preserves exact `<Book>` order, original known and unknown metadata, and later repair evidence.
- DTDs/entities, malformed structure, missing required attributes, oversized inputs, and excessive entry counts are rejected.
- Imported lists and owned records are persisted transactionally; deletion cascades and progress integrity are enforced.
- Original imported data remains separate from normalized comparison values.
- Matching resolves series first, then issue/chapter identity.
- Automatic operations never silently replace confirmed mappings, overrides, rejections, or skips.
- Candidate searches require explicit action, query only the visible effective source set, use bounded concurrency/timeouts, and never add candidates to the ordinary library automatically.
- Manual review reads persisted state without starting extension searches.
- Standard Yomori builds are telemetry-free and local-first. Network use belongs to visible user-selected extensions, configured trackers, or other explicit external actions.
- Development signing is public and test-only. It must never be used for production.
- Public release automation and inherited Mihon website/update release hooks remain disabled.

## Matching defaults

Initial merged defaults, subject to focused evidence:

- Automatic acceptance: at least 88%.
- Review range: 65% through 87.99%.
- Unresolved: below 65%.
- Required lead over runner-up: 10 percentage points.
- Minimum title similarity for automatic acceptance: 85%.
- Equivalent issue identity and membership in the visible effective source set are mandatory safety gates.

Exact scoring details and matcher changes require source, tests, and documentation updates. Branch-only changes are not merged defaults.

## Source preference hierarchy

Highest to lowest:

1. Entry-specific confirmed match or source override.
2. Series-specific confirmed mapping or source preference.
3. Reading-list source order.
4. Explicitly assigned user-configured category defaults, where implemented.
5. Global source preference, where implemented.

Never silently bypass an unavailable higher-priority confirmed or overridden source with a lower-priority source.

## Reading and availability invariants

- Persisted CBL order is authoritative for reading-list navigation.
- Ordinary manga-scoped reader behavior remains separate unless explicitly changed and tested.
- Unresolved, rejected, skipped, removed, unavailable, or rematch-required entries stop visibly and offer explicit Review, Skip, or Stop behavior.
- Chapter read state is shared; reading-list position and completion are list-specific.
- Cached content, mappings, database rows, or an already-open reader do not prove the exact extension is installed and enabled.
- Before materializing or continuing source-backed content, current package-manager and extension-enabled state must be verified.
- Failure preserves imported metadata, mappings, decisions, and unaffected progress.

## Implementation sequence

1. Repository governance and independent identity — complete on `main`.
2. Safe CBL model/parser and fixtures — complete on `main`.
3. SQLDelight persistence and migrations through merged migration 16 — complete on `main`.
4. Normalization, scoring, source selection, candidate persistence/search, and manual review — complete on `main`.
5. Cross-series navigation and list-specific progress — implemented only on draft PR #15; blocked and unmerged.
6. Repair/rematching tools and later approved source-setting/category work — planned or branch-specific; verify before describing as implemented.

## FLOSS and publication status

Primary open-source publication target: F-Droid. Accrescent requirements are used as a security-hardening overlay. Detailed evidence belongs in `docs/RELEASE_READINESS.md`.

Current state is blocked by, at minimum:

- no protected production signing or documented continuity/recovery process;
- no accepted F-Droid recipe, metadata, screenshots, or source-built artifact;
- incomplete dependency, native/prebuilt binary, asset, font, translation, and licence/provenance inventory;
- unresolved Firebase/Crashlytics/telemetry-module exclusion evidence for the F-Droid path;
- updater, executable-extension installation, Shizuku/package-management, broad permission, cleartext-network and exported-component review;
- no unsigned same-package non-debuggable F-Droid production variant;
- no independent repeated build and byte-for-byte comparison;
- incomplete privacy, security, support, attribution, changelog, store metadata, accessibility, localization, backup/restore, and representative-device release evidence;
- unresolved PR #15 disabled-extension blocker.

A local or branch build does not prove reproducibility, F-Droid acceptance, store compliance, production signing, or release readiness.

## Release blockers

Before any public APK, tag, release, announcement, or store submission:

- resolve all required blockers in `docs/RELEASE_READINESS.md`;
- resolve and retest the disabled-extension availability defect;
- finish original Yomori branding and licensed release assets;
- remove or replace inherited Mihon update, support, download, website, signing, and publication identities;
- complete dependency/binary/asset licence and source-completeness audits;
- establish protected production signing, certificate continuity, recovery, deterministic artifacts, checksums, and matching source tags;
- establish and independently verify the intended F-Droid build path and anti-feature declarations;
- complete representative extension, backup/restore, migration, accessibility, localization, screen-size, Android-version, permission, networking, and physical-device QA;
- prepare public privacy, security, support, attribution, changelog, donation, and store-metadata routes;
- obtain explicit final release approval.

## Upstream baseline

Fork baseline at project creation:

- upstream commit: `b4635c41a8dd5e30edf480b0c9bdc80d0fda0520`;
- upstream release line: Mihon `0.20.1`;
- baseline date: 2026-07-10.

Revalidate upstream state before any synchronization. Preserve Yomori identity, source neutrality, privacy, extension compatibility, CBL invariants, signing separation, disabled cloud automation, and all confirmed user-control rules.