# Manual Matching Search

Status: planned; not implemented in the current merged baseline or draft PR #15.

The intended flow lets the user:

1. open one unresolved, ambiguous, unavailable, or explicitly selected entry;
2. edit the search query;
3. search only installed sources already permitted for that reading list;
4. choose a remote series;
5. inspect its issue list;
6. bind one exact issue as a user-confirmed entry match.

Manual search must not expand the allowed source set, bypass an unavailable confirmed mapping, restore a rejected candidate implicitly, clear a skip silently, or add candidates to the normal library.

Implementation requires bounded requests, cancellation, persisted evidence, focused tests, and documentation updates.
