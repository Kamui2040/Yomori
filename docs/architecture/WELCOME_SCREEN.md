# Yomori welcome screen

## Purpose

Yomori uses the shared cross-project welcome-screen composition as the first page of its mandatory first-launch flow. The composition is shared; Yomori copy, colors, trust statements, legal content, and actions remain project-specific.

The welcome page precedes the existing theme, storage, permission, and guide setup pages. Continuing from the welcome page does not mark onboarding complete. The existing `onboarding_complete` preference is written only when the complete onboarding flow finishes.

## Information order

Top to bottom:

1. K2040 developer avatar.
2. Yomori app name.
3. Short Yomori description.
4. Compact trust statement.
5. Collapsed version/build details.
6. Collapsed licence, source, privacy, and usage details.
7. Optional K2040 Ko-fi support action.
8. Short thank-you message.
9. Sticky Exit and Continue actions.

The welcome page is scrollable between the identity header and sticky actions so large text and narrow screens remain usable.

## Yomori-specific trust statement

The welcome page communicates these stable product properties without implying that source-backed reading is offline:

- local-first;
- no account required for core use;
- no Yomori ads, analytics, tracking, or telemetry;
- content sources remain explicitly user-selected;
- compatible extensions are separate user-installed software;
- Yomori does not provide, recommend, preselect, install, or trust content sources.

## Visual rules

- Use the active Yomori `MaterialTheme` color scheme rather than copying another project's accent palette.
- Use rounded grouped surfaces, generous vertical spacing, high-contrast text, and minimum Material touch targets.
- Version and legal details start collapsed.
- Middle content scrolls; Exit and Continue remain visible at the bottom.
- The developer avatar is identity artwork, not the Yomori application icon.

## Mandatory behavior

Before onboarding is completed:

- system Back must not dismiss the onboarding flow;
- the welcome page exposes only Exit and Continue as primary dismissal/progression actions;
- Exit closes the app task without setting onboarding complete;
- Continue advances to the existing setup flow;
- relaunch after Exit shows the welcome page again;
- external legal/support links do not mark onboarding complete.

## Avatar publication gate

The final screen must use the approved K2040 wolf avatar. The repository currently records that asset as not bundled because an explicit redistribution-compatible licence has not yet been established in `docs/ASSET_ATTRIBUTION.md`.

Until that public asset gate is resolved, implementation branches may keep a clearly identified developer-avatar placeholder for layout and accessibility validation, but the welcome screen must not be treated as release-ready or visually accepted. Do not extract, regenerate, substitute, or publish a competing avatar solely to bypass the licence gate.

## Validation requirements

Before merge, verify:

- Kotlin formatting and compilation;
- unit/regression tests and preview assembly;
- exact development signing identity for produced APKs;
- first launch shows the welcome page before setup;
- Continue reaches the existing onboarding pages without changing their behavior;
- Back cannot bypass incomplete onboarding;
- Exit closes the task and does not persist completion;
- version and legal sections expand/collapse independently;
- support and public-repository links are optional external actions;
- portrait, landscape, narrow-screen, dark/light theme, large-text, and screen-reader behavior;
- sticky actions remain reachable while middle content scrolls;
- the approved avatar replaces the placeholder only after repository-local rights/licence evidence is complete.
