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

    suspend fun updateProgress(
        id: Long,
        currentPosition: Int?,
        completed: Boolean = false,
    ): Boolean

    suspend fun setEntrySkipped(
        readingListId: Long,
        entryId: Long,
        skipped: Boolean,
    ): Boolean

    suspend fun markEntryReaderFailure(
        entryId: Long,
        state: ReadingListEntryResolutionState,
    ): Boolean

    suspend fun clearEntryReaderFailure(entryId: Long): Boolean

    suspend fun delete(id: Long)
}
