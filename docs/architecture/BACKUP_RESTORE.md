# Backup and Restore Expectations

Status: required release behavior; complete cross-version verification remains pending.

Reading-list backups must retain:

- original CBL metadata and authoritative order;
- selected source IDs and priority, including unavailable IDs;
- candidate snapshots and evidence needed for review;
- confirmed series mappings and entry overrides;
- rejected candidates and skips;
- list-specific position and completion;
- matcher/evidence versions and failure states.

Restore must tolerate missing extensions and mark affected mappings unavailable rather than deleting or replacing them.

Credentials, cookies, signing keys, and extension APKs are not reading-list backup data.

Before public release, verify backup creation, restoration, migration, partial failure, missing-source behavior, and compatibility across every supported public version.
