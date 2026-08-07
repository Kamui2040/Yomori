# Unified Welcome and About Composition

Status: approved design direction; welcome implementation in progress; unified in-app About presentation pending.

## Purpose

Yomori follows the shared cross-project welcome-screen composition while keeping Yomori-specific wording, colors, trust statements, legal details, and optional actions. The shared guide defines information order, grouping, dismissal behavior, and accessibility expectations; it does not prescribe another project's copy or color tokens.

The same composition should also inform Yomori's later in-app About surface so first-launch and About remain visually and structurally consistent.

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

The exact master and intended Yomori runtime derivative are recorded in `../ASSET_ATTRIBUTION.md`. The master is licensed by K2040 under Creative Commons Attribution 4.0 International (CC BY 4.0). Yomori bundles the already-validated 512 × 512 lossless WebP derivative at `app/src/main/res/drawable-nodpi/k2040_wolf_avatar.webp`, preserving the recorded derivative SHA-256 and attribution.

Do not substitute a different avatar or silently regenerate/re-encode the approved derivative. A different export is a new derivative and needs its own identity and QA record.

### App name

Display `Yomori` prominently using the active Yomori theme's primary/accent treatment.

### Short description

Keep this to one or two concise lines. The current Yomori copy is:

> Source-agnostic comic reading for imported CBL reading orders.

Localization may adapt sentence structure while preserving that meaning.

### Trust statement

Present the most important Yomori trust properties at a glance:

- Local-first · No account · No ads or telemetry.
- Sources and extensions remain user-controlled.

Do not claim that Yomori is fully offline: reading through user-selected extensions may use the network.

### Version

Show the application version in a collapsed row by default. Expansion may include build/version identifiers useful for support. Do not expose private environment paths, signing secrets, device identifiers, or internal workflow records.

### Legal, sources, privacy, and attribution

A dedicated details section exposes public-safe information for:

- Apache-2.0 licence;
- Mihon/Tachiyomi derivation and non-affiliation;
- Yomori source code;
- privacy statement;
- security reporting;
- support scope;
- third-party-source / extension responsibility;
- `K2040 — K2040 wolf avatar — CC BY 4.0` and the CC BY 4.0 licence.

Opening this section must not contact an extension or content source.

### Optional support

Ko-fi may be shown as a clearly secondary optional action using the public support route already documented for Yomori. Donations must not unlock features, suppress limits, change matching, alter source access, remove advertising, or create hidden entitlements.

### Thank you

Use a short project-specific line:

> Thanks for testing and helping shape Yomori.

### Actions

For the mandatory first-launch acknowledgement, provide only explicit **Exit** and **Continue** actions. Back, outside-tap dismissal, and a close icon must not bypass the acknowledgement.

Continue persists only the dedicated Yomori acknowledgement state. Any still-required upstream setup/onboarding continues separately. Exit closes the app task without completing either state.

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

Every interactive element requires an appropriate accessible label. Reading order must match the visual top-to-bottom information order. Expanded/collapsed state must be understandable to accessibility services. Decorative graphics must not create duplicate screen-reader content.

The design must remain usable with TalkBack, keyboard/switch navigation where supported, large text, high contrast, and dark theme.

## State and persistence

The mandatory welcome/acknowledgement is shown until the user explicitly continues. It uses its own local `yomori_welcome_complete` state rather than overloading the inherited `onboarding_complete` state.

A version change must not automatically reset acknowledgement unless a later migration has an explicitly documented reason to require renewed acknowledgement. The About surface remains available independently after acknowledgement.

Do not make first-launch completion depend on an account, cloud service, network request, extension, tracker, analytics SDK, or remote configuration.

The existing Mihon onboarding state remains separate: the Yomori acknowledgement completes first, then any still-required setup/onboarding flow may continue. Existing users who previously completed upstream onboarding still receive the Yomori acknowledgement once.

## Implementation boundary

Implementation should reuse existing Yomori/Mihon Compose primitives where practical and must not alter extension-facing compatibility APIs. It must not introduce telemetry, account requirements, source recommendation, source selection, extension installation, or extension trust.

Before the welcome implementation is merge-ready:

- bundle and byte-verify the recorded lossless WebP derivative;
- recheck the current F-Droid asset/inclusion rules against the exact bundled asset set;
- pass focused state tests for the independent acknowledgement/setup boundary;
- verify Back cannot bypass the mandatory variant;
- verify external intents and inherited update/donation surfaces cannot cover or bypass the mandatory acknowledgement;
- verify legal/support links and external intents are explicit and safe;
- perform large-font, narrow-screen, dark-theme, TalkBack, and physical-device QA;
- review `../RELEASE_READINESS.md` and `../ASSET_ATTRIBUTION.md` against the exact bundled assets.

The unified in-app About presentation remains a follow-up until it is separately implemented and validated with normal dismissal behavior.
