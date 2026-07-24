# Matching Examples

These examples explain decisions; exact component weights remain in `SCORING.md` and code.

## Strong and unambiguous

CBL:

- Series: `Watchmen`
- Number: `1`
- Year: `1986`

Candidate:

- title similarity above the automatic title gate;
- equivalent issue number;
- compatible year;
- final confidence at least 88%;
- lead over the runner-up at least 10 points;
- source is selected for the reading list;
- no conflicting confirmed mapping.

Result: eligible for automatic matching.

## High score with issue conflict

CBL issue `1` and candidate issue `2` have excellent title and year evidence.

Result: not eligible for automatic matching. Unrelated evidence cannot bypass the issue-safety gate.

## Missing optional year

Titles and issue identity match, but the source does not provide a year.

Result: missing optional evidence is neutral. The candidate may still qualify if every mandatory gate and confidence rule passes.

## Conflicting year

The title and issue match, but the source year conflicts with a known CBL year.

Result: apply the documented penalty. The conflict remains visible in persisted evidence and may require review.

## Two qualifying candidates

Two candidates pass every mandatory gate. One has a higher final confidence.

Result: choose the stronger candidate. The mere existence of another qualifying candidate does not force review.

## Exact confidence tie

Two candidates pass every mandatory gate with the same confidence.

Result: use effective source priority, then stable candidate identity or persisted rank. Never use raw extension return order as the primary identity rule.

## Confirmed mapping unavailable

A user-confirmed series mapping points to an unavailable selected source.

Result: show the source as unavailable. Do not silently search or fall back to another source.

## Rejected candidate returned again

A later search returns a previously rejected candidate with unchanged identity.

Result: retain it for review history but exclude it from automatic selection until explicitly restored or confirmed.

## Skipped entry

An entry is explicitly skipped.

Result: automatic search and resolution do not clear the skip. Only an explicit user action may select a match and clear it.
