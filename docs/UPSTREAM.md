# Upstream Synchronization

Yomori is based on `mihonapp/mihon` and should stay close enough to upstream that security fixes, Android compatibility changes, and extension-API updates can be adopted without large rewrites.

## Remotes for a local checkout

Verify the exact configured remotes before fetching:

```sh
git remote -v
```

Expected remotes:

- `origin`: `https://github.com/Kamui2040/Yomori.git`
- `upstream`: `https://github.com/mihonapp/mihon.git`

Fetch only the known branch refs needed for the synchronization review:

```sh
git fetch --no-tags origin refs/heads/main:refs/remotes/origin/main
git fetch --no-tags upstream refs/heads/main:refs/remotes/upstream/main
```

Do not prune, delete, rewrite, or broadly fetch unrelated refs as an incidental part of discovery.

## Synchronization workflow

1. Start from a clean, current Yomori `main` and verify the canonical repository root.
2. Verify `origin/main` and `upstream/main` after the bounded fetch.
3. Create a focused synchronization branch such as `agent/sync-mihon-YYYY-MM-DD`.
4. Merge upstream into that branch without discarding Yomori changes or rewriting shared history.
5. Resolve conflicts using `AGENTS.md` and `PROJECT_CONTEXT.md` as product constraints; never accept either side blindly.
6. Review extension loader, source API, database migrations, build tooling, updater, telemetry, branding, permissions, networking, backup, and reader changes explicitly.
7. Run the applicable local Gradle-wrapper, migration, formatting, assembly, diff, and device-validation baseline. GitHub Actions and other cloud CI are not PC validation dependencies.
8. Review the complete changed-file scope, licences, generated files, private-data exposure, and release impact.
9. Open or update a focused pull request that records the upstream range, conflict decisions, local validation actually performed, remaining device gates, and retained Yomori divergences.

## Protected Yomori decisions

An upstream synchronization must not silently restore or weaken:

- Mihon product identity, branding, release links, update endpoints, support routes, or publication hooks;
- the Yomori production and development application IDs or signing separation;
- telemetry, analytics, advertising, tracking, or mandatory cloud/account behavior in standard builds;
- automatic source recommendation, preselection, installation, or trust;
- bundled content sources or extension repositories;
- querying outside the visible user-selected effective source set;
- exact CBL order, original metadata, repair evidence, or transactional import behavior;
- user-confirmed mappings, overrides, rejections, skips, or unavailable-source visibility;
- bounded extension networking, signature checks, explicit failure, and extension-facing compatibility;
- list-specific reading progress, visible blocked-entry handling, or ordinary-reader separation;
- disabled public release automation or the local-first PC validation policy.

## Compatibility review

For each upstream update, inspect changes involving:

- `source-api` and `eu.kanade.tachiyomi.source` compatibility;
- extension loading, metadata versions, signing, trust, and package availability;
- database schema, migrations, transactions, backup, and restore;
- reader chapter navigation and reading-list progress;
- Android SDK, Gradle, dependencies, permissions, exported components, WebViews, file handling, and networking;
- updater, telemetry, external-service, signing, packaging, and release behavior;
- licences, notices, bundled assets, and generated build inputs.

Record material long-lived divergence, decisions, blockers, and verified merged state in `PROJECT_CONTEXT.md` or the appropriate focused architecture document. Do not claim device, build, compatibility, or release evidence that was not performed.
