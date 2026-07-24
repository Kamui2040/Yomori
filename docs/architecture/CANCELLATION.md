# Matching Cancellation

Candidate search is explicitly cancellable from the Reading Lists overview.

Current behavior:

- one keyed job is tracked per reading-list ID;
- new duplicate search requests are ignored while a list search is active;
- queued and active coroutine work is cancelled cooperatively;
- visible search state is removed in `finally`;
- deletion marks the list as deleting, cancels and joins its active search, then deletes list-owned data;
- reimporting a list does not inherit stale search results from a deleted list ID.

Cancellation does not clear confirmations, rejections, skips, overrides, mappings, or completed transactional writes.

Future resumable matching must persist an explicit incomplete state and must not represent a partially executed operation as complete.
