# Cross-series reader navigation

## Purpose

A Yomori reading-list session follows the persisted Comic Book Lover entry order across series and user-selected sources. It does not derive the next item from a manga's ordinary chapter list.

## Session identity

A reader session carries:

- reading-list ID;
- current reading-list entry ID and position;
- exact local manga and chapter IDs used by the normal reader;
- previous/next availability in the reading-list order.

Normal manga reader launches remain unchanged when no reading-list identity is supplied.

## Start and resume

- The Reading Lists screen exposes an explicit Read/Resume action for each list; review, search, source editing, and deletion remain separate actions.
- Source or network activity for materialization begins only after that explicit read/resume action or a reading-list transition initiated by the user.
- A list that has not started begins at position zero.
- An in-progress list resumes at its persisted current position.
- A completed list offers an explicit restart from position zero; completion is not inferred from global chapter read state.
- Opening an entry persists that position for the list.

## Exact entry resolution

A readable entry must retain all three persisted identities:

- selected source ID;
- remote manga URL;
- remote chapter URL.

The source must still be selected for the list and installed as a compatible online source. Yomori first reuses existing local manga/chapter rows by source and remote URLs. When they are absent, an explicit read action fetches the selected series' chapter list without performing another broad search or requiring a full details refresh, then materializes only the exact matched manga/chapter as non-favorite local rows. Candidate search results are not bulk-added to the library.

Materialization must never:

- query an unselected source;
- replace a user-confirmed mapping;
- silently substitute a different series or issue;
- mark an entry skipped;
- add the manga to the library or a category automatically.

## Navigation order

- Previous and next actions use reading-list positions, including when consecutive entries belong to the same manga.
- Completing a chapter preserves Mihon's shared chapter read state.
- Advancing the list persists the next reading-list position independently of chapter read state.
- Completing the final entry records list-specific completion without pointing progress at a nonexistent entry.
- Returning to an earlier entry clears list completion and persists that entry as current.

## Blocking entries

An entry is not silently bypassed when it is:

- unsearched, ambiguous, or unresolved;
- source unavailable;
- chapter removed or marked for rematch;
- explicitly skipped;
- missing a persisted source, manga URL, or chapter URL;
- no longer materializable from the selected installed source.

At a blocking entry, the user must explicitly choose one of:

- **Review** — leave the reader and open that list's review screen;
- **Skip** — persist the skip for that entry and continue to the immediately following position;
- **Stop** — leave progress on the blocking position and close the session.

A skip is list-specific and does not alter global chapter state. Confirming an exact candidate later clears that entry's skip through the existing confirmation path.

## Failure isolation

A timeout or extension failure blocks and marks only the affected entry. Original CBL metadata, candidate history, rejections, overrides, series mappings, saved match identities, and other entries remain unchanged.

## Reader integration

- The existing reader continues to load pages, update chapter history, bookmarks, tracking, and shared read state.
- Reading-list next/previous controls supersede ordinary manga adjacency only for a reading-list session.
- Cross-series transitions open the exact next resolved entry in a fresh reader instance, avoiding mutation of the existing manga-scoped loader and chapter list.
- Page preloading remains manga-scoped; Yomori does not preload another source across a list boundary.

## Persistence

SQLDelight stores list-specific completion separately from `current_position`. Repository updates validate that any non-null current position belongs to the list. Progress, completion, explicit skips, and repairable reader failures are written through `ReadingListRepository`; the app layer does not issue direct SQLDelight writes. Entry-state writes preserve the persisted source/manga/chapter identity and user-confirmation flag.

## Required tests

- start, resume, restart, and final completion;
- exact CBL ordering across different manga and sources;
- same-manga entries still follow list order rather than manga chapter order;
- existing local row reuse and exact non-favorite materialization;
- source-selection and installed-source enforcement;
- unresolved, ambiguous, unavailable, removed, rematch, and skipped gates;
- explicit skip advances by exactly one position and never silently skips additional entries;
- previous navigation and completion reset;
- shared chapter read state with independent list position/completion;
- process/activity recreation retains list identity;
- compact portrait layout keeps Read, Review, Search, Edit, and Delete usable;
- missing list, entry, source, manga, or chapter failure isolation;
- no unselected-source fallback or automatic library/category insertion.
