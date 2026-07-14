# Reading-List Manual Review

## Purpose

The manual-review interface is the next Yomori product stage after candidate-search orchestration. It presents persisted reading-list candidates for explicit user decisions while preserving original CBL metadata, confirmed mappings, rejection history, selected-source boundaries, and extension compatibility.

Opening the review interface must not trigger candidate searches or any other extension network request. Candidate refresh remains a separate explicit action.

## Entry point and ordering

Each reading list exposes a dedicated review/details action while retaining separate source-edit, candidate-search, and delete actions.

The review screen:

- loads the authoritative reading list and its persisted resolution data;
- displays entries in original CBL `<Book>` order;
- keeps completed and protected entries visible for context;
- makes `AMBIGUOUS`, `UNRESOLVED`, and `SOURCE_UNAVAILABLE` entries easy to find;
- never hides unresolved entries or silently drops unavailable sources or candidates.

Original series, issue number, volume, year, ordered database references, warnings, unknown attributes, and unknown elements remain authoritative and unchanged.

## Candidate presentation

Candidates use the existing deterministic persisted ordering. Equal high-scoring candidates remain visibly ambiguous; reading-list source order only stabilizes display ordering and must not be presented as an automatic tie-break.

Each candidate presentation includes:

- total confidence score;
- lead over the runner-up;
- decision reason;
- source name and language;
- remote series and issue identity;
- volume and year evidence;
- title similarity;
- issue-number equivalence;
- external-identifier evidence when available;
- source-preference level;
- confirmed-history evidence;
- complete score-component breakdown;
- conflicts and missing evidence;
- rejected status.

The UI must distinguish annual, special, Free Comic Book Day, one-shot, zero or negative, decimal, fraction, suffix, and opaque issue identities without collapsing them into regular numbers.

## Explicit actions

The review interface uses the existing `ReadingListResolutionRepository` contracts.

### Confirm entry candidate

Confirmation:

- calls `confirmResolution` with the exact persisted candidate snapshot;
- records the entry as user-confirmed;
- clears only the matching candidate rejection and the existing skipped state as defined by the repository;
- never modifies other entries or unrelated rejection history;
- becomes authoritative and cannot be silently replaced by later automatic search.

### Reject candidate

Rejection:

- calls `rejectCandidate` with the exact persisted snapshot;
- remains stored independently from candidate refreshes;
- keeps the candidate visible for review;
- excludes the candidate from later automatic decisions.

### Restore rejected candidate

Restoration:

- calls `clearCandidateRejection` for the exact candidate identity;
- does not confirm or auto-select the candidate;
- does not clear unrelated rejections.

### Confirm series mapping

A candidate may be promoted to a list-local series mapping only through a separate explicit action. The UI must explain that the mapping applies to the normalized series key rather than only the current entry.

Series confirmation:

- calls `confirmSeriesMapping` with the candidate source and manga identity;
- never occurs implicitly as a side effect of entry confirmation;
- cannot later be replaced by an automatic series mapping;
- remains visible and removable through an explicit user action.

### Existing overrides and mappings

Existing entry overrides and confirmed series mappings are shown clearly. The review UI must not silently replace, bypass, or reinterpret them. If their source or remote target is unavailable, the entry remains visibly unresolved or unavailable rather than falling back to a lower-priority source.

Advanced override editing may be implemented only if it remains explicit and within this same protection model. It must not broaden source access beyond the reading list's user-selected sources.

## Persistence and resumability

Every successful confirmation, rejection, restoration, or series-mapping action is persisted immediately. The visible state is then reloaded from repository data rather than relying only on transient UI state.

Completed decisions must survive:

- navigation away from the screen;
- app restart;
- cancellation of later work;
- a later source failure;
- a later candidate refresh.

A failed action must not discard earlier successful decisions. The UI must surface the failure and retain the last persisted state.

## Source and library boundaries

- Opening or browsing review data performs no source search or network request.
- Only the existing explicit candidate-search action may query extensions.
- No source, extension repository, or remote result is bundled, recommended, preselected, auto-installed, or auto-trusted.
- Candidate records remain outside Mihon's normal library.
- Reviewing or confirming a candidate does not automatically add a series to the normal library.
- Missing extension IDs and unavailable sources remain visible for later repair.
- Existing extension signature and trust controls remain unchanged.

## Screen-model responsibilities

The screen model should expose a deterministic presentation model joining:

- reading-list entries;
- persisted candidate snapshots;
- rejection state;
- entry overrides;
- series mappings;
- original CBL metadata and warnings.

It should provide explicit operations for:

- confirming an entry candidate;
- rejecting a candidate;
- restoring a rejected candidate;
- confirming or clearing a series mapping;
- reloading persisted state after each operation.

Loading, empty, missing-list, action-in-progress, and action-failure states must be represented without losing previously loaded review data unnecessarily.

## Scope boundaries

This stage does not include:

- cross-series reader navigation or progress behavior;
- repair and rematching workflows beyond linking to the existing explicit candidate-search action;
- automatic source installation or recommendations;
- automatic library insertion;
- user-facing score-weight customization;
- unrelated upstream refactors or rebranding;
- production release, signing, or update-endpoint work.

## Required tests

Focused tests must cover:

- original CBL entry order;
- presentation of ambiguous, unresolved, unavailable, auto-matched, confirmed, and skipped states;
- deterministic candidate ranking and visible equal-score ambiguity;
- accurate score, lead, source, language, decision reason, breakdown, and conflict presentation;
- exact candidate confirmation;
- rejection and restoration without unrelated history loss;
- explicit series confirmation and protection from later automatic replacement;
- existing user-confirmed entry and series mappings never being silently replaced;
- unavailable sources and removed candidates remaining visible;
- persisted state being reproduced after screen recreation;
- screen opening performing no source search or network request;
- cancellation or failed actions preserving earlier successful confirmations.

## Validation and QA

Before merge, run focused tests plus `spotlessCheck`, `testDebugUnitTest`, `verifySqlDelightMigration`, development assembly, and `git diff --check`. Inspect the complete diff and changed-file scope, then require authoritative GitHub Actions success.

Device QA should use a development APK and representative imported lists covering ambiguous candidates, low confidence, no candidates, missing extensions, rejected-candidate restoration, entry confirmation, explicit series confirmation, app restart, later candidate refresh, and the supported issue-number distinctions.
