# Future Welcome and About Surfaces

Status: approved composition; application implementation pending.

Yomori follows the shared cross-project welcome/About composition documented in [`architecture/WELCOME_SCREEN.md`](./architecture/WELCOME_SCREEN.md). The shared composition defines information order, grouping, dismissal, and accessibility behavior; Yomori keeps its own wording, colors, trust statements, legal content, and optional actions.

## Developer identity

- Display name: K2040.
- The approved K2040 personal avatar is the intended identity element for the welcome and About surfaces.
- The avatar represents the developer, not the Yomori application icon.
- Redistribution licence: Creative Commons Attribution 4.0 International (CC BY 4.0), with attribution to K2040.
- The asset is not currently bundled in Git, an APK, F-Droid metadata, or store materials.
- Before public bundling, record the exact approved asset's public-safe provenance and stable repository asset identity in `ASSET_ATTRIBUTION.md`.

Do not substitute a different avatar merely to unblock implementation. Private storage locations, identifiers, recovery records, and unpublished asset metadata must not be copied into this repository.

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

The first-launch acknowledgement uses explicit Exit and Continue actions and cannot be bypassed through Back, outside-tap dismissal, or a close icon. The normal in-app About surface remains dismissible through standard navigation.

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
- applicable asset/dependency attribution, including the K2040 avatar's CC BY 4.0 attribution when bundled;
- changelog or release notes when a public release exists;
- optional Ko-fi support;
- Yomori's non-affiliation with Mihon and third-party content providers.

The UI must remain accessible with text scaling, screen readers, dark mode, narrow screens, supported localizations, and at least 48 dp touch targets.
