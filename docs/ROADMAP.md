# Roadmap

This roadmap separates merged foundations from approved follow-up work. `PROJECT_CONTEXT.md` remains the canonical statement of current merged and explicitly recorded branch state.

## Milestone 0: Repository foundation

- Yomori project identity and documentation
- Telemetry-free development builds
- Independent production and development application IDs
- Reproducible public development signing for the `.debug` package
- Local PC validation and an explicitly authorized phone-build workflow
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

Approved follow-up, not yet merged:

- Select the unique strongest candidate when all safety gates pass
- Never use raw extension return order as the identity decision
- Resolve exact score ties by effective source priority, then stable candidate identity or rank
- Retain runner-up evidence
- Preserve issue distinctions including annual, special, FCBD, one-shot, zero, negative, decimal, fraction, suffix, and opaque identifiers
- Add cancellable, resumable, state-aware matching execution

## Milestone 3: Import and review workflow

Merged baseline:

- CBL import flow
- Per-list extension selection and ranking
- Candidate review
- Entry overrides and confirmed series mappings
- Explicit confirmation, rejection, restoration, and skip handling

Approved follow-up:

- Settings → Reading Sources
- Ordered global default matching sources
- Per-list global-default or custom mode
- Source search and language filtering
- Remembered language filter
- Grouped or collapsible language variants
- Visible progress, cancellation, and state-aware retry

## Milestone 4: Reading

Immediate correction:

- Restore a two-row Reading Lists overview item
- Give the reading-list title the full available width
- Place Read or Resume, Review, and labelled overflow actions on a separate row
- Preserve visible search progress and existing stored list progress

Cross-series reader work:

- Exact persisted CBL order
- Cross-series next and previous navigation
- List-specific position and completion
- Resume, restart, and completion behavior
- Explicit Review, Skip, or Stop handling
- Representative phone QA and ordinary-reader regression checks

Next stage:

- Repair and rematching tools
- Operate only on broken, unresolved, or explicitly selected entries
- Preserve confirmed decisions, rejected candidates, skips, exceptions, and original metadata
- No silent source fallback, removal, replacement, or skipped entry

## Milestone 5: Organization and optional integration

- Reading-list categories
- Create, rename, reorder, and safely delete categories
- Category-level ordered default sources
- Visible source inheritance with list-specific overrides
- Optional explicit addition of resolved results to the normal library
- Select or create a normal-library category before confirmation
- Edit the reading-list title before confirmation
- Keep candidate-search results out of the normal library

Reading-list categories and normal-library categories remain separate concepts.

## Milestone 6: Release readiness

- Final Yomori visual identity
- Remove or replace inherited Mihon update, support, and download endpoints
- Protected production signing and documented key custody
- Backup and restore coverage
- Accessibility and representative physical-device testing
- Attribution and modified-file notices
- Public release workflow and documentation
