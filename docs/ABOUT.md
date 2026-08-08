# Welcome and Future About Surfaces

Status: first-launch welcome implementation complete and locally validated on PR #22; physical-device visual/accessibility QA remains pending; unified in-app About presentation remains a follow-up.

Yomori follows the shared cross-project welcome/About composition documented in [`architecture/WELCOME_SCREEN.md`](./architecture/WELCOME_SCREEN.md). The shared composition defines hierarchy, grouping, navigation, dismissal, proportions, and accessibility behavior; Yomori keeps its own wording, colors, trust statements, legal content, and optional actions.

## Developer identity

- Display name: K2040.
- The approved K2040 personal avatar is the identity element for the welcome and future About surfaces.
- The avatar represents the developer, not the Yomori application icon.
- Owner / licensor: K2040.
- Redistribution licence: Creative Commons Attribution 4.0 International (CC BY 4.0).
- Required attribution: `K2040 — K2040 wolf avatar — CC BY 4.0`.
- Canonical master and the exact approved 512 × 512 lossless WebP runtime derivative are identified by checksum in `ASSET_ATTRIBUTION.md`.

Yomori bundles only that recorded runtime derivative unless a later reviewed change intentionally creates and documents a new derivative. Private storage locations, identifiers, recovery records, and unpublished asset metadata must not be copied into this repository.

## Implemented first-launch composition

The mandatory welcome keeps only the K2040 avatar and Yomori name permanently visible above these rows:

1. **About** — inline disclosure containing the source-agnostic CBL-reading description and Yomori trust statements.
2. **Version x.x.x / Changelog** — right-chevron navigation to a dedicated scrollable internal changelog card with explicit Back.
3. **License & usage** — right-chevron navigation to a dedicated scrollable internal legal/usage card with explicit Back.
4. **Support on Ko-fi** — right-chevron outbound row that opens the public Ko-fi route directly in the external browser.
5. **Thanks / Credits** — inline disclosure containing the thank-you, upstream/source information, avatar attribution, and future contributor-credit space.
6. Explicit **Exit** and **Continue** actions on the mandatory main card.

The description and trust statements are not permanently placed above the rows. Trust text must not appear between the changelog and licence rows. Changelog and License use dedicated internal cards rather than inline expansion; Support is direct external navigation rather than an inline disclosure or embedded button.

The first-launch acknowledgement cannot be bypassed through Back, outside-tap dismissal, or a close icon. Android Back from an internal detail card returns to the main welcome card without completing acknowledgement. Detail cards do not contain Exit / Continue. After Continue, any still-required setup/onboarding flow may proceed.

The future normal in-app About surface should reuse the same identity, visual language, information model, and public-safe content where appropriate, but it remains a separate implementation and must use normal dismissible navigation rather than mandatory acknowledgement behavior.

## Current Yomori copy and trust boundary

The welcome's About disclosure uses:

> Source-agnostic comic reading for imported CBL reading orders.

> Local-first · No account · No ads or telemetry

> Sources and extensions remain user-controlled

These statements do not claim fully offline operation. Source-backed reading may use the network through explicit user actions and user-selected integrations or extensions.

The development-build changelog fallback is:

> No published changelog is bundled with this development build.

Do not invent release notes or expose internal commit/build metadata as a substitute for a published changelog.

## Optional support

Ko-fi: https://ko-fi.com/k2040

The welcome exposes this as an explicit external navigation row. A future About surface may expose the same public route using context-appropriate normal navigation. Donations must not unlock features, suppress limits, grant content access, alter matching or source behavior, remove advertising, or create undisclosed entitlements.

## Required public information

The welcome's License & usage and Thanks / Credits surfaces provide or route to public-safe information for:

- source code;
- Apache-2.0 licence and upstream attribution;
- Mihon/Tachiyomi derivation and non-affiliation;
- privacy statement and telemetry/network-use boundary;
- security reporting;
- support scope;
- third-party-source and extension responsibility;
- applicable asset/dependency attribution, including the K2040 avatar's CC BY 4.0 attribution;
- changelog or release notes when a public release exists;
- optional Ko-fi support;
- Yomori's non-affiliation with Mihon and third-party content providers.

The UI must remain accessible with text scaling, screen readers, dark mode, narrow screens, supported localizations, scrollable detail content, and at least 48 dp touch targets.

## Validation boundary

The PR #22 welcome implementation has passed retained local clean/Spotless/debug-unit-test/SQLDelight/preview-assembly validation, focused first-launch tests (`4/0/0/0`), exact five-preview-APK inventory and public-development certificate checks, plus public-safety and workflow-source gates. GitHub Actions runtime operations were not used.

Physical-device visual/accessibility/navigation QA remains required before merge readiness is claimed. The unified in-app About presentation also remains pending and must be separately implemented and validated.
