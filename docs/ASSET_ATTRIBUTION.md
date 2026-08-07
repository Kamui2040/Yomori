# Asset Attribution and Licence Status

This file tracks release-relevant visual, font, audio, translation, and other bundled assets. It is not yet a complete audit.

## K2040 developer avatar

### Canonical master

- Name: `K2040-wolf-avatar.png`
- Role: approved cross-project K2040 developer-identity master; not an application icon unless a target project separately approves that role
- Owner / licensor identity: K2040
- Format: PNG, 1254 × 1254, RGBA
- Size: 3,366,468 bytes
- SHA-256: `a60d2e0a597212d16bfeb148264f4c67d8f35069b3a1cb7e0492ac5e47e781f0`
- Public-safe provenance: verified project-controlled approved master, preserved in the private cross-project asset library since 2026-07-24; the repository copy or a runtime derivative does not replace the canonical master

### Yomori runtime derivative

Yomori should bundle the already-validated lossless WebP derivative rather than the 3.3 MB master:

- Source relationship: 512 × 512 derivative of the canonical master; prior asset QA verified that its decoded pixels match the documented 512 × 512 Lanczos resize of the master
- Proposed repository path: `app/src/main/res/drawable-nodpi/k2040_wolf_avatar.webp`
- Format: lossless WebP, 512 × 512, RGBA
- Size: 311,826 bytes
- SHA-256: `b179d2eaa16eb807568aebcc48fd66f5feba0e38749dcd23f06b49e2b63ee155`

Any different export is a separate derivative and requires its own hash, relationship, and visual QA record.

### Licence and attribution

The exact canonical master identified above, and Yomori's documented derivative of it, are licensed by K2040 under the **Creative Commons Attribution 4.0 International (CC BY 4.0)** licence.

Required attribution:

`K2040 — K2040 wolf avatar — CC BY 4.0`

CC BY 4.0 permits redistribution, commercial use, and adaptation subject to attribution and licence-notice requirements; it carries no NonCommercial or NoDerivatives restriction. This is compatible with the intended FLOSS/F-Droid asset boundary, while the complete Yomori dependency and asset audit remains independently incomplete.

Do not copy private storage locations, private identifiers, recovery records, or unpublished asset metadata into the repository. Recheck current F-Droid asset/inclusion rules against the exact final bundled asset set before release.

## Yomori application assets

Status: **PARTIAL**

Before release, inventory and licence every:

- launcher and adaptive icon;
- notification and shortcut icon;
- illustration, screenshot, banner, and feature graphic;
- font or typeface;
- audio asset;
- translation and locale resource;
- bundled native binary or prebuilt data file.

Inherited assets must retain required upstream notices. Temporary branding must not be represented as final store artwork.

## Release rule

A public release is blocked while any bundled asset lacks verified provenance and a redistribution-compatible licence.
