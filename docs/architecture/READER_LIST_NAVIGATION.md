# Reading-List Reader Navigation

Status: implemented on draft PR #15. The detailed contract is `CROSS_SERIES_READER.md`.

A Yomori reading-list session carries explicit reading-list, entry, position, manga, chapter, and selected-source identity. It does not replace ordinary manga-scoped navigation.

At the end of an entry, the reading-list reader resolves the next persisted CBL position. Moving backward across the first page resolves the previous persisted position. The destination may belong to another series or selected source.

Unresolved, ambiguous, unavailable, removed, rematch-required, incomplete, or skipped entries remain in order and stop visibly with explicit Review, Skip, or Stop choices.

Chapter read state remains shared. Reading-list position and completion remain list-specific.

Device QA status and remaining cases are recorded in `../../PROJECT_CONTEXT.md`.
