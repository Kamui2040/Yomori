# Security Policy

Yomori is in pre-release development.

## Private vulnerability reporting

Use GitHub's private vulnerability-reporting form for this repository:

https://github.com/Kamui2040/Yomori/security/advisories/new

Do not publish exploit details, credentials, private CBL files, source cookies, tokens, signing material, or copyrighted pages in a public issue.

When private reporting is unavailable, contact the repository owner through the GitHub profile before sharing sensitive details. The private route must be verified again before the first public release.

## In scope

Security reports may include:

- extension signature, trust, loading, or package-isolation failures;
- source-scope bypass or undisclosed network behavior;
- unsafe XML processing or unbounded imported input;
- credential, token, cookie, backup, or private-data exposure;
- exported component, deep-link, WebView, file-sharing, or intent abuse;
- package installation or updater behavior;
- production-signing or release-integrity failures;
- silent replacement, fallback, skipping, or deletion that compromises user-controlled data.

## Third-party extensions and services

Yomori does not maintain third-party content sources, extension repositories, or extensions. A report about a third-party extension should be sent to its maintainer unless Yomori's loader, trust, signature, isolation, or permission handling is the cause.

## Supported versions

No production version is supported yet. Security fixes target the current development branch and later public release lines when they exist.

## Disclosure

Allow reasonable time for investigation and a coordinated fix before public disclosure. Publication, signing, and release decisions remain separate controlled operations.
