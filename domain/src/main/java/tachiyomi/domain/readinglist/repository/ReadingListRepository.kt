package tachiyomi.domain.readinglist.repository

import kotlinx.coroutines.flow.Flow
import tachiyomi.domain.readinglist.cbl.model.CblReadingList
import tachiyomi.domain.readinglist.model.ReadingList
import tachiyomi.domain.readinglist.model.ReadingListEntryResolutionState
import tachiyomi.domain.readinglist.model.ReadingListSummary

interface ReadingListRepository {

    suspend fun get(id: Long): ReadingList?

    suspend fun getAll(): List<ReadingListSummary>

    fun getAllAsFlow(): Flow<List<ReadingListSummary>>

    suspend fun insert(readingList: CblReadingList, selectedSourceIds: List<Long>): Long

    suspend fun updateSources(id: Long, selectedSourceIds: List<Long>): Boolean

    /** Persist list-specific position and completion without changing shared chapter read state. */
    suspend fun updateProgress(
        id: Long,
        currentPosition: Int?,
        completed: Boolean = false,
    ): Boolean

    /** Persist an explicit list-entry skip while preserving its CBL and match metadata. */
    suspend fun setEntrySkipped(
        readingListId: Long,
        entryId: Long,
        skipped: Boolean,
    ): Boolean

    /** Mark one entry with a repairable reader failure without deleting its saved identity. */
    suspend fun markEntryReaderFailure(
        entryId: Long,
        state: ReadingListEntryResolutionState,
    ): Boolean

    /** Restore the protected resolved state after a reader failure has been repaired. */
    suspend fun clearEntryReaderFailure(entryId: Long): Boolean

    suspend fun delete(id: Long)
}
