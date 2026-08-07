# CBL Matching V1 Acceptance Criteria

Status: the core milestone is implemented; manual ad-hoc search and broader repair tooling remain planned.

| Criterion | Status |
|---|---|
| Parse a valid local CBL without changing entry order | Implemented |
| Preserve original metadata and external identifiers | Implemented |
| Reject unsafe or malformed XML with typed failures | Implemented |
| Select and rank installed compatible sources per list | Implemented |
| Group equivalent series work and avoid duplicate fetches | Implemented |
| Deterministic 0–100 evidence and persisted breakdown | Implemented |
| Automatic acceptance with mandatory safety gates | Implemented |
| Persist ambiguous, unresolved, confirmed, and rejected state | Implemented |
| List, series, and entry-level source decisions | Partly implemented; global/category defaults are planned |
| Protect confirmed mappings during later searches | Implemented |
| Keep rejected candidates excluded until explicit action | Implemented |
| Focused unit and migration tests | Implemented |
| Manual ad-hoc query editing and remote-series browsing | Planned |
| Representative real-list release QA | Partial; current branch device checks are documented in `PROJECT_CONTEXT.md` |

The milestone is not a release-readiness claim. F-Droid, security, signing, metadata, and full device requirements remain in `../RELEASE_READINESS.md`.
