# Roadmap

This roadmap separates merged foundations, current branch work, and approved follow-ups. `PROJECT_CONTEXT.md` is the canonical status and decision ledger.

## Milestone 0: Repository foundation

- Yomori product identity and documentation
- Telemetry-free development builds
- Independent production and development application IDs
- Reproducible public development signing for the `.debug` package
- Local PC validation
- Dormant manual phone-build workflow while repository Actions are disabled
- Upstream synchronization process

## Milestone 1: CBL core

- Safe bounded CBL parser
- Original known and unknown metadata preservation
- Domain model
- Fixtures and unit tests
- Transactional reading-list persistence and migrations
- Ordered source selections with unavailable IDs retained visibly

## Milestone 2: Matching core

Merged baseline:

- Title and issue normalization
- Confidence scoring and ambiguity margin
- Mandatory title and issue safety gates
- Persistent confirmed and rejected mappings
- Candidate snapshots and complete score evidence
- Series-first bounded selected-source search
- Confirmation-protected automatic resolution

Approved follow-up:

- Select the unique strongest candidate when every safety gate passes
- Never use raw extension return order as the identity decision
- Resolve exact score ties by effective source priority, then stable candidate identity or rank
- Retain runner-up evidence
- Preserve annual, special, FCBD, one-shot, zero, negative, decimal, fraction, suffix, and opaque issue distinctions
- Add resumable matching state where it can be implemented without silent partial completion

## Milestone 3: Import and review workflow

Merged baseline:

- local CBL document-picker import
- per-list extension selection and ranking
- explicit candidate search
- visible candidate-search progress and cancellation
- candidate review
- entry overrides and confirmed series mappings
- explicit confirmation, rejection, restoration, and skip handling
- defensive search cancellation before list deletion

Approved follow-up:

- Settings → Reading Sources
- ordered global default matching sources
- per-list global-default or custom mode
- source search and language filtering improvements
- grouped or collapsible language variants
- manual ad-hoc search for unresolved entries
- state-aware retry and repair

## Milestone 4: Reading

Implemented on draft PR #15:

- exact persisted CBL order
- cross-series next and previous navigation
- list-specific position and completion
- resume, restart, and completion behavior
- explicit Review, Skip, or Stop handling
- two-row Reading Lists layout with direct actions
- ordinary-reader isolation

Device QA passed:

- exact first entry
- next and previous CBL boundaries
- resume on the persisted second entry
- selected-source preservation
- ordinary page navigation
- ordinary-reader regression isolation

Remaining device QA:

- completed-list restart
- final-list completion
- unresolved Review, Skip, and Stop
- unavailable-source handling
- final accessibility and narrow-screen observations

## Milestone 5: Repair, organization, and optional integration

- repair and rematching only for broken, unresolved, or explicitly selected entries
- preserve confirmed decisions, rejected candidates, skips, exceptions, and original metadata
- reading-list categories
- category-level ordered default sources
- visible source inheritance with list-specific overrides
- optional explicit addition of resolved series to the normal library
- explicit normal-library category choice
- editable reading-list title
- candidate-search results remain outside the normal library

Reading-list categories and normal-library categories remain separate concepts.

## Milestone 6: Open-source release readiness

Governing baseline:

- F-Droid-compatible source, dependency, licence, build, metadata, and anti-feature state
- Accrescent-compatible security posture
- universal signing, privacy, legal, quality, metadata, identity, and artifact requirements
- minimal store-specific adaptations

Required work:

- complete code, dependency, prebuilt-binary, translation, and asset licence audit
- final Yomori visual identity and licensed store artwork
- remove or replace inherited Mihon update, support, download, and website endpoints
- F-Droid-safe treatment of self-update and executable extension-package behavior
- cleartext, Shizuku, package-installation, and permission hardening or variant isolation
- protected production signing and key custody
- reproducible or independently rebuildable release path
- deterministic release filenames, source tags, checksums, and certificate records
- privacy, security, support, funding, attribution, and non-affiliation routes
- Fastlane-compatible metadata, screenshots, descriptions, changelogs, and declarations
- backup, migration, permission, offline, accessibility, localization, screen-size, Android-version, and representative device QA
- live policy verification for each selected store

See `RELEASE_READINESS.md`.
