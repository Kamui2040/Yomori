# CBL Import Flow

The Reading Lists tab is Yomori's entry point for local Comic Book Lover (`.cbl`) files.

## Implemented import sequence

1. The user chooses **Import .cbl**.
2. Android's system document picker grants temporary access.
3. Yomori reads at most 16 MiB and detects UTF-8, UTF-16LE, or UTF-16BE.
4. The parser validates XML, rejects DTD/entity declarations, preserves book order, and returns typed warnings or failures.
5. Empty or invalid reading lists are rejected.
6. Yomori waits for installed-extension discovery and groups online sources by extension package.
7. The user searches and filters installed source variants.
8. The user selects at least one currently installed online source and arranges priority.
9. The list, entries, database references, and source order commit in one SQLDelight transaction.

No source is bundled, recommended, preselected, installed, or trusted automatically.

## Source editing

Source selection can be changed after import. Stored IDs whose extensions are missing remain visible as unavailable entries. Saving still requires at least one installed online source.

## List deletion

Deletion requires confirmation, cancels and joins active keyed candidate-search work, and then removes only list-owned records through the database cascade. It does not delete extensions, remote content, normal-library membership, downloads, or shared chapter read state.

## Candidate search

Each list exposes an explicit search action. Search:

- queries only installed online sources selected for that list;
- preserves their priority;
- groups entries by normalized title, known year, and volume;
- shares a three-request global limit;
- applies a 30-second timeout per extension request;
- uses only the first source result page;
- retains at most ten series results per source;
- fetches issue lists for at most the three strongest series results per source;
- stores at most twenty-four ranked issue candidates per entry;
- keeps candidates outside the normal library;
- protects confirmed, rejected, skipped, overridden, and mapped state at the transactional boundary;
- reports unavailable or failing sources without silent fallback.

Search progress is visible. The active search action becomes an explicit cancellation control.

## Manual review

Review loads persisted data only and performs no extension request. It preserves original order and displays confidence, runner-up evidence, decision reason, source/language, remote identity, score components, conflicts, rejection state, overrides, and series mappings.

Confirmation, rejection, restoration, mapping confirmation, and mapping removal are separate persisted actions.

## Reader continuation

Draft PR #15 implements exact cross-series reading, list-specific position/completion, resume/restart, and explicit blocked-entry decisions. Device status is recorded in `PROJECT_CONTEXT.md`.

## Planned continuation

- manual ad-hoc query editing for unresolved entries;
- focused repair and rematching;
- global and category source defaults;
- optional explicit normal-library integration.
