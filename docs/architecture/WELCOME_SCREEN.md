# Unified Welcome and About Composition

Status: first-launch welcome implementation complete and locally validated on PR #22; physical-device visual/accessibility QA remains pending; unified in-app About presentation remains a follow-up.

## Purpose

Yomori follows the shared cross-project welcome-screen composition while keeping Yomori-specific wording, colors, trust statements, legal details, and optional actions. The shared guide defines the overall hierarchy, grouping, dismissal behavior, proportions, and accessibility expectations; it does not prescribe another project's copy or color tokens.

The same composition should also inform Yomori's later in-app About surface so first-launch and About remain visually and structurally consistent without making the non-mandatory About surface behave like an acknowledgement gate.

## Main welcome hierarchy

Only the approved K2040 developer avatar and the `Yomori` name remain permanently visible above the information rows. The main card then presents these rows in order:

1. **About** — expands inline.
2. **Version %s / Changelog** — navigates to a dedicated internal detail card.
3. **License & usage** — navigates to a dedicated internal detail card.
4. **Support on Ko-fi** — opens the public Ko-fi route directly in the external browser.
5. **Thanks / Credits** — expands inline.
6. Mandatory **Exit** and **Continue** actions remain available on the main welcome card.

The short description and trust statements belong inside the expanded **About** row rather than appearing permanently between the title and the rows. The thank-you, upstream/source attribution, avatar attribution, and related credit links belong inside **Thanks / Credits**. Trust text must not appear between the changelog and licence rows.

The middle information area may scroll when needed. The mandatory Exit / Continue actions should remain reachable and visually stable without being duplicated inside detail cards.

## Yomori adaptation

### Developer avatar

Use the approved K2040 personal avatar, not the Yomori application icon. The avatar is the shared personal identity element across projects.

The exact master and intended Yomori runtime derivative are recorded in `../ASSET_ATTRIBUTION.md`. The master is licensed by K2040 under Creative Commons Attribution 4.0 International (CC BY 4.0). Yomori bundles the already-validated 512 × 512 lossless WebP derivative at `app/src/main/res/drawable-nodpi/k2040_wolf_avatar.webp`, preserving the recorded derivative SHA-256 and attribution.

Do not substitute a different avatar or silently regenerate/re-encode the approved derivative. A different export is a new derivative and needs its own identity and QA record.

### App name

Display `Yomori` prominently using the active Yomori theme's primary/accent treatment.

### About

**About** expands inline and contains the concise Yomori description and trust statements:

> Source-agnostic comic reading for imported CBL reading orders.

> Local-first · No account · No ads or telemetry

> Sources and extensions remain user-controlled

Localization may adapt sentence structure while preserving those meanings. Do not claim that Yomori is fully offline: reading through user-selected extensions may use the network.

The row exposes an accessible expanded/collapsed state rather than a navigation chevron.

### Version / Changelog

The row title includes the current application version and `/ Changelog`. It uses a right-facing navigation chevron because it opens a dedicated internal detail card rather than expanding inline.

The detail card is scrollable, is changelog-only, and provides an explicit **Back** action. For a development build with no canonical bundled changelog, the exact fallback is:

> No published changelog is bundled with this development build.

Do not invent release notes, expose commit SHAs as user-facing changelog entries, or substitute internal workflow/build metadata for a published changelog.

Android Back from this detail card returns to the main welcome card. The detail card must not contain Exit / Continue and must not complete or bypass acknowledgement.

### License & usage

**License & usage** uses a right-facing navigation chevron and opens a dedicated scrollable internal detail card with an explicit **Back** action.

The card exposes public-safe information for:

- Apache-2.0 licence;
- Mihon/Tachiyomi derivation and non-affiliation;
- source neutrality and separate user-installed compatible extensions;
- privacy/telemetry posture and explicit network-use boundary;
- Yomori source code;
- privacy statement;
- security reporting;
- support scope where applicable;
- `K2040 — K2040 wolf avatar — CC BY 4.0` and the CC BY 4.0 licence.

Opening this card must not contact an extension or content source. Android Back returns to the main welcome card. The detail card must not contain Exit / Continue and must not complete or bypass acknowledgement.

### Support on Ko-fi

**Support on Ko-fi** is an outbound navigation row, not an expandable disclosure and not an embedded secondary button. It uses a right-facing chevron to indicate that tapping the row leaves the app and opens the documented public Ko-fi route in the external browser.

Donations must not unlock features, suppress limits, change matching, alter source access, remove advertising, or create hidden entitlements. Opening Ko-fi is always an explicit user action.

### Thanks / Credits

**Thanks / Credits** expands inline. It contains the short project thank-you plus public-safe upstream/source and avatar attribution, with room for future contributor credits where applicable.

The current thank-you is:

> Thanks for testing and helping shape Yomori.

The row's accessibility wording may reference thanks, credits, and sources while the visible title remains `Thanks / Credits`. The row exposes an accessible expanded/collapsed state rather than a navigation chevron.

### Actions

For the mandatory first-launch acknowledgement, provide only explicit **Exit** and **Continue** actions. Back, outside-tap dismissal, and a close icon must not bypass the acknowledgement.

Continue persists only the dedicated Yomori acknowledgement state. Any still-required upstream setup/onboarding continues separately. Exit closes the app task without completing either state.

For the future non-mandatory About presentation, normal Back/Close dismissal is allowed and the surface must not behave like an acknowledgement gate.

The acknowledgement is a Yomori product/legal-information gate, not consent for tracking, analytics, source installation, extension trust, or external accounts.

## Theme, composition, and scaling

Do not copy colors from another project's guide. Use Yomori's current Material theme tokens and maintain sufficient contrast in light/dark themes. Project accent colors may evolve independently without changing this composition contract.

The approved visual reference establishes composition and proportions rather than another app's colors or copy. On a typical portrait phone, target a centered rounded card at roughly 88% of the available width, information rows at roughly 84% of the card width, and an avatar around 30% of the card width. These are proportional guides, not rigid dimensions: accessibility, safe areas, localization, narrow screens, tablets, landscape, font scaling, and system insets take precedence.

Use a tighter vertical rhythm than the earlier full-screen prototype while preserving clear grouping. Avoid hard-coded decorative colors when semantic Material theme colors can express the same hierarchy.

Support narrow phones, tablets, landscape, large font sizes, and display scaling without clipped controls. Allow the information area and internal detail cards to scroll. Keep mandatory actions reachable without relying on gestures unavailable to accessibility services.

Minimum touch target: 48 dp. Do not encode meaning by color alone.

## Accessibility and navigation semantics

Every interactive element requires an appropriate accessible label. Reading order must match the visual top-to-bottom order. Inline expanded/collapsed state must be understandable to accessibility services; navigation rows must communicate their navigation purpose. Decorative graphics must not create duplicate screen-reader content.

Right-facing chevrons are reserved here for navigation: Changelog and License navigate to internal detail cards, while Support navigates to an external browser destination. About and Thanks / Credits use disclosure semantics instead.

The design must remain usable with TalkBack, keyboard/switch navigation where supported, large text, high contrast, and dark theme. Physical-device validation of these properties remains required before merge readiness is claimed.

## State and persistence

The mandatory welcome/acknowledgement is shown until the user explicitly continues. It uses its own local `yomori_welcome_complete` state rather than overloading the inherited `onboarding_complete` state.

A version change must not automatically reset acknowledgement unless a later migration has an explicitly documented reason to require renewed acknowledgement. The future About surface remains independently available after acknowledgement.

Do not make first-launch completion depend on an account, cloud service, network request, extension, tracker, analytics SDK, or remote configuration.

The existing Mihon onboarding state remains separate: the Yomori acknowledgement completes first, then any still-required setup/onboarding flow may continue. Existing users who previously completed upstream onboarding still receive the Yomori acknowledgement once.

## Implementation and validation boundary

The first-launch implementation reuses existing Yomori/Mihon Compose primitives where practical and does not alter extension-facing compatibility APIs. It must not introduce telemetry, account requirements, source recommendation, source selection, extension installation, or extension trust.

The PR #22 implementation has passed the retained local validation set: clean build preparation, Spotless, debug unit tests, SQLDelight migration verification, preview assembly, focused first-launch tests (`4/0/0/0`), exact five-preview-APK inventory, public-development certificate verification, and public-safety/workflow-source checks. GitHub Actions runtime operations were not used for that validation.

Still required before this welcome change is merge-ready:

- physical-device QA on the authorized Yomori test device;
- verify Back cannot bypass the mandatory main card or either detail card;
- verify the Ko-fi external intent is explicit and returns safely to the acknowledgement;
- verify inherited update/donation/external surfaces cannot cover or bypass the mandatory acknowledgement;
- verify narrow-screen, large-font, dark-theme, TalkBack, scrolling, and touch-target behavior on device;
- review `../RELEASE_READINESS.md` and `../ASSET_ATTRIBUTION.md` against the exact bundled assets and device evidence.

The unified in-app About presentation remains a follow-up until it is separately implemented and validated with normal dismissal behavior.
