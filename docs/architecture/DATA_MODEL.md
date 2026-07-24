# Reading-List Data Model

Status: implemented baseline with future repair and organization extensions.

## Reading list

`reading_lists` stores list identity, import metadata, warnings, source mode, current position, completion, and timestamps.

## Reading-list entry

`reading_list_entries` stores authoritative CBL order, original metadata, matching state, optional resolved identities, confidence summary, user-confirmation state, and skip state.

Original CBL data remains independently available after normalization or resolution.

## Database references

Ordered database references preserve external series and issue evidence from each imported book.

## Source selection

`reading_list_sources` stores ordered user-selected source IDs. Missing IDs remain visible as unavailable choices.

## Candidate snapshots

Candidate records retain source, language, remote identity, rank, score, runner-up evidence, decision reason, conflicts, and the complete serialized score breakdown needed for review.

## Series mappings, overrides, and rejections

- Series mappings store list-local user-confirmed remote series identity.
- Entry overrides constrain source and chapter selection for one entry.
- Rejected candidates persist independently from refreshes.
- User-confirmed mappings, rejections, overrides, and skips are protected from automatic replacement.

## Progress

Chapter read state remains shared with the ordinary reader. Reading-list position and completion remain list-specific.

## Invariants

- Entry position follows original `<Book>` order.
- A reading-list progress pointer cannot reference a missing entry.
- Deleting a list cascades only records owned by that list.
- Deleting a list does not delete unrelated library chapters, downloads, or shared read state.
- Broken or unavailable mappings remain inspectable and repairable.
