# Upstream Synchronization

Yomori is based on `mihonapp/mihon` and should remain close enough to adopt security fixes, Android compatibility changes, and extension-API updates without large rewrites.

## Remotes

A normal checkout uses:

```text
origin   https://github.com/Kamui2040/Yomori.git
upstream https://github.com/mihonapp/mihon.git
```

Verify live remotes rather than assuming these values.

## Synchronization process

1. Fetch `origin` and `upstream`.
2. Confirm the live `main` branch, open pull requests, repository Actions setting, and working-tree state.
3. Review upstream changes affecting source APIs, extension loading, signature trust, Android compatibility, backup, reader behavior, permissions, privacy, or release automation.
4. Create a focused synchronization branch.
5. Resolve conflicts deliberately; never accept either side blindly.
6. Preserve Yomori identity, application IDs, source neutrality, extension-facing namespaces, CBL invariants, telemetry-free behavior, signing separation, and disabled inherited release automation.
7. Run local repository-wrapper checks and relevant physical-device QA.
8. Update `PROJECT_CONTEXT.md` and architecture documents when merged behavior or the upstream baseline changes.
9. Merge only under the higher-level project merge controls.

## Protected divergences

Upstream synchronization must not restore:

- Mihon public branding, support, update, download, website, or release endpoints;
- bundled or recommended sources;
- hidden source selection or fallback;
- telemetry in standard builds;
- production use of the public development certificate;
- inherited release automation;
- incompatible renaming of `eu.kanade.tachiyomi.source` contracts.

## Attribution

Preserve Apache-2.0 licensing, upstream copyright notices, modified-file notices where required, and accurate non-affiliation wording.
