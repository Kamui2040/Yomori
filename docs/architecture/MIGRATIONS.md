# Database Migration Expectations

Reading-list schema changes use SQLDelight migrations and must pass the repository-wrapper `verifySqlDelightMigration` task locally. GitHub Actions is disabled and is not the validation authority for current PC work.

Migrations must preserve authoritative CBL order, original metadata, selected source order, unavailable source IDs, user-confirmed mappings, overrides, rejected candidates, skips, progress, completion, and failure states.

Destructive migration is not acceptable for released data without an explicit export-and-recovery path.

Current reading-list migrations include:

- migration 15: ordered per-list source selections;
- migration 16: candidate snapshots, rejection history, entry overrides, and series mappings;
- migration 17: list-specific completion state.

Foreign keys may cascade only records owned by the reading list or entry. They must not alter unrelated normal-library membership, downloads, shared chapter read state, or extension-facing APIs.

Before public release, validate backup and restore across every supported public schema version.
