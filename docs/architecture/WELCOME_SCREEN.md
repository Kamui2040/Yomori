# Unified Welcome and About Composition

Status: approved design direction; implementation pending.

## Purpose

Yomori follows the shared cross-project welcome-screen composition while keeping Yomori-specific wording, colors, trust statements, legal details, and optional actions. The shared guide defines information order, grouping, dismissal behavior, and accessibility expectations; it does not prescribe another project's copy or color tokens.

The same composition should also inform Yomori's later in-app About surface so first-launch and About remain visually and structurally consistent without duplicating content logic.

## Information order

Top to bottom:

1. Developer avatar.
2. App name.
3. Short description.
4. Trust statement.
5. Version, collapsed by default.
6. Legal, sources, privacy, and attribution details.
7. Optional support action.
8. Short thank-you text.
9. Actions.

Essential information appears before expandable detail. The middle content may scroll; the final actions remain visible when practical.

## Yomori adaptation

### Developer avatar

Use the approved K2040 personal avatar, not the Yomori application icon. The avatar is the shared personal identity element across projects.

The selected redistribution licence is Creative Commons Attribution 4.0 International (CC BY 4.0), with attribution to K2040. This preserves required attribution while allowing redistribution, commercial use, and adaptation without NonCommercial or NoDerivatives restrictions.

Do not bundle a substitute avatar merely to unblock implementation. The approved avatar binary must not enter Git, an APK, F-Droid metadata, or store materials until `../ASSET_ATTRIBUTION.md` records the exact approved asset's public-safe provenance and stable repository identity alongside the CC BY 4.0 attribution.

### App name

Display `Yomori` prominently using the active Yomori theme's primary/accent treatment.

### Short description

Keep this to one or two concise lines. The initial Yomori copy direction is:

> Source-agnostic comic reading for imported CBL reading orders.

Localization may adapt sentence structure while preserving that meaning.

### Trust statement

Present the most important Yomori trust properties at a glance. Initial content direction:

- Local-first · No account · No ads or telemetry.
- Sources and extensions remain user-controlled.

Do not claim that Yomori is fully offline: reading through user-selected extensions may use the network.

### Version

Show the application version in a collapsed row by default. Expansion may include build/version-code information and other public-safe diagnostic identifiers useful for support. Do not expose private environment paths, signing secrets, device identifiers, or internal workflow records.

### Legal, sources, privacy, and attribution

A dedicated details row/surface should expose public-safe information for:

- Apache-2.0 licence;
- Mihon/Tachiyomi derivation and non-affiliation;
- Yomori source code;
- privacy statement;
- security reporting;
- support scope;
- third-party-source / extension responsibility;
- applicable asset and dependency attribution, including the K2040 avatar's CC BY 4.0 attribution when bundled;
- release notes or changelog when a public release exists.

Opening this section must not contact an extension or content source.

### Optional support

Ko-fi may be shown as a clearly secondary optional action using the public support route already documented for Yomori. Donations must not unlock features, suppress limits, change matching, alter source access, remove advertising, or create hidden entitlements.

### Thank you

Use a short project-specific line. Initial direction:

> Thanks for testing and helping shape Yomori.

### Actions

For a mandatory first-launch acknowledgement, provide only explicit **Exit** and **Continue** actions. Back, outside-tap dismissal, and a close icon must not bypass the acknowledgement.

For a non-mandatory About presentation, normal Back/Close dismissal is allowed and the screen must not behave like an acknowledgement gate.

The acknowledgement is a Yomori product/legal-information gate, not consent for tracking, analytics, source installation, extension trust, or external accounts.

## Theme and color

Do not copy colors from another project's guide. Use Yomori's current Material theme tokens and maintain sufficient contrast in light/dark themes. Project accent colors may evolve independently without changing this composition contract.

Avoid hard-coded decorative colors when semantic Material theme colors can express the same hierarchy.

## Layout and scaling

- Preserve generous vertical spacing and rounded grouping containers.
- Keep the title and essential trust information above optional detail.
- Support narrow phones, tablets, landscape, large font sizes, and display scaling without clipped controls.
- Allow the middle content to scroll when needed.
- Keep mandatory actions reachable and visible without relying on gestures that are unavailable to accessibility services.
- Minimum touch target: 48 dp.
- Do not encode meaning by color alone.

## Accessibility

Every interactive element requires an appropriate accessible label. Reading order must match the visual top-to-bottom information order. Expanded/collapsed state must be announced. Decorative graphics must not create duplicate screen-reader content.

The design must remain usable with TalkBack, keyboard/switch navigation where supported, large text, high contrast, and dark theme.

## State and persistence

The mandatory welcome/acknowledgement is shown until the user explicitly continues. Persist only the minimum local completion state needed to avoid showing it again unnecessarily.

A version change must not automatically reset acknowledgement unless a later migration has an explicitly documented reason to require renewed acknowledgement. The About surface remains available independently after acknowledgement.

Do not make first-launch completion depend on an account, cloud service, network request, extension, tracker, analytics SDK, or remote configuration.

## Implementation boundary

Implementation should reuse existing Yomori/Mihon Compose primitives where practical and must not alter extension-facing compatibility APIs. It must not introduce telemetry, account requirements, source recommendation, source selection, extension installation, or extension trust.

Before implementation is considered release-ready:

- record the exact approved avatar binary's public-safe provenance and repository identity while retaining the CC BY 4.0 attribution;
- recheck the current F-Droid asset/inclusion rules against the exact bundled asset set;
- add focused state/persistence tests for mandatory acknowledgement;
- verify Back/outside-tap/close cannot bypass the mandatory variant;
- verify About remains normally dismissible;
- verify legal/support links and external intents are explicit and safe;
- perform large-font, narrow-screen, dark-theme, TalkBack, and physical-device QA;
- review `../RELEASE_READINESS.md` and `../ASSET_ATTRIBUTION.md` against the exact bundled assets.
