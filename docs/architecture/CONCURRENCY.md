# Bounded Source Concurrency

Current implementation uses one shared semaphore with a maximum of three simultaneous extension requests across active reading-list candidate searches.

Series-first grouping reduces duplicate work:

- one first-page series search per selected source and distinct series group;
- each selected source/remote-series issue list is fetched at most once per operation;
- each extension request has a 30-second timeout;
- stored series and issue candidates are bounded before persistence.

Cancellation removes queued work and requests cooperative cancellation of active work. Completed repository writes remain transactional and protected by list identity, confirmation, rejection, and skip rules.

Do not change request bounds without focused tests, documentation, and visible network-behavior review.
