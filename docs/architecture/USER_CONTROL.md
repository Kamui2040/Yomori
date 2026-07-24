# User Control and Source Overrides

## Current implemented hierarchy

1. Entry-specific confirmed match or source override
2. Series-specific confirmed mapping or source preference
3. Reading-list source order

A broader rule never overwrites a narrower confirmed rule without explicit user action.

An unavailable confirmed or overridden source is surfaced visibly and is not silently bypassed.

## Approved future hierarchy

After global and category source settings are implemented and tested:

4. Explicitly assigned reading-list category defaults
5. Global source preferences

Inherited defaults must be visible and editable before save or search. They must never become hidden recommendations, installation, trust, or query scope.

## Entry actions

Current review supports persisted candidate confirmation, rejection/restoration, series mapping, and skip protection.

Manual ad-hoc search and normal-library integration remain planned. They must stay within the reading list's explicit source set.
