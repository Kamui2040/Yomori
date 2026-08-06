# Yomori Privacy Statement

Status: pre-release documentation for the current standard Yomori build.

## Summary

Standard Yomori builds are telemetry-free and local-first. Yomori does not operate a central account, content, analytics, advertising, matching, crash-reporting, or synchronization service.

## Data stored locally

Depending on user actions, Yomori may store:

- library and chapter metadata inherited from the reader;
- imported CBL metadata and original entry order;
- selected source IDs and priority;
- match candidates, scores, confirmations, rejections, skips, and overrides;
- reading-list position and completion;
- application preferences, history, downloads, and backups;
- credentials or tokens entered for optional third-party tracking services.

Reading-list metadata remains on the device unless the user exports or backs it up.

## Network activity

Yomori can access the network when the user:

- uses a user-installed compatible extension;
- explicitly searches selected sources for reading-list matches;
- reads or downloads content through a selected source;
- signs in to or uses an optional third-party tracking service;
- opens a user-selected web page or other external service.

Extensions and external services are third-party software or services with their own privacy practices. Yomori does not send a complete reading list to a central Yomori service.

## Permissions and executable extensions

Compatible extensions are separate user-installed APKs and are treated as untrusted executable code. Yomori preserves signature and trust controls, but an installed extension may contact services chosen by that extension.

The current pre-release application also inherits package-management, package-query, background-work, and network capabilities that require store-specific review. See `docs/RELEASE_READINESS.md`.

## Logs and diagnostics

Diagnostics must not intentionally include cookies, authorization headers, source credentials, signing material, private backup contents, or copyrighted pages. Users should review and redact logs before sharing them.

## Backup, export, and deletion

The application can create or restore user-controlled backups. Backups may contain library and reading-list metadata. They do not intentionally include extension APKs.

Users can remove reading lists and application data. Uninstalling the application removes app-private data according to Android behavior, but user-created exports, downloaded files, and third-party service data may remain separately.

## No sale or advertising profile

Yomori does not sell personal data, display advertising, or create an advertising profile.

## Changes

This statement must be reverified against the exact production artifact before the first public release and after any material permission, network, backup, telemetry, account, or service change.
