# Future Welcome and About Surfaces

Status: approved composition; welcome implementation in progress; unified in-app About presentation remains pending.

Yomori follows the shared cross-project welcome/About composition documented in [`architecture/WELCOME_SCREEN.md`](./architecture/WELCOME_SCREEN.md). The shared composition defines information order, grouping, dismissal, and accessibility behavior; Yomori keeps its own wording, colors, trust statements, legal content, and optional actions.

## Developer identity

- Display name: K2040.
- The approved K2040 personal avatar is the identity element for the welcome and About surfaces.
- The avatar represents the developer, not the Yomori application icon.
- Owner / licensor: K2040.
- Redistribution licence: Creative Commons Attribution 4.0 International (CC BY 4.0).
- Required attribution: `K2040 — K2040 wolf avatar — CC BY 4.0`.
- Canonical master and the exact approved 512 × 512 lossless WebP runtime derivative are identified by checksum in `ASSET_ATTRIBUTION.md`.

Yomori should bundle only that recorded runtime derivative unless a later reviewed change intentionally creates and documents a new derivative. Private storage locations, identifiers, recovery records, and unpublished asset metadata must not be copied into this repository.

## Yomori-specific content direction

The welcome/About composition should present, in order:

1. K2040 avatar;
2. Yomori name;
3. a one- or two-line source-agnostic CBL-reading description;
4. Yomori trust points such as local-first operation, no account, no ads/telemetry, and user-controlled sources/extensions;
5. collapsed version information;
6. legal, source, privacy, support, security, and attribution details;
7. optional Ko-fi support;
8. a short thank-you line;
9. context-appropriate actions.

The first-launch acknowledgement uses explicit Exit and Continue actions and cannot be bypassed through Back, outside-tap dismissal, or a close icon. After Continue, any still-required setup/onboarding flow may proceed. The normal in-app About surface remains dismissible through standard navigation.

## Optional support

Ko-fi: https://ko-fi.com/k2040

The About and welcome surfaces may expose this as a clearly secondary optional external link. Donations must not unlock features, suppress limits, grant content access, alter matching or source behavior, remove advertising, or create undisclosed entitlements.

## Required public information

Before public release, the About/legal details should expose stable public routes for:

- source code;
- Apache-2.0 licence and upstream attribution;
- privacy statement;
- security reporting;
- support scope;
- third-party-source and extension responsibility;
- applicable asset/dependency attribution, including the K2040 avatar's CC BY 4.0 attribution;
- changelog or release notes when a public release exists;
- optional Ko-fi support;
- Yomori's non-affiliation with Mihon and third-party content providers.

The UI must remain accessible with text scaling, screen readers, dark mode, narrow screens, supported localizations, and at least 48 dp touch targets.
