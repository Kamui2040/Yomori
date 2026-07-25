# Directional blocked-entry skip note

This temporary branch note records the PR #15 behavior under focused device QA.

When a blocked reading-list entry is reached while moving forward, **Skip** marks only that entry skipped and continues to the immediately following CBL position.

When a blocked reading-list entry is reached while moving backward, **Skip** marks only that entry skipped and continues to the immediately preceding CBL position. A readable previous entry opens on its final page. A second blocked entry produces another stable Review / Skip / Stop decision instead of being silently bypassed.

This behavior applies only to reading-list navigation. Ordinary manga-scoped reader behavior remains unchanged.
