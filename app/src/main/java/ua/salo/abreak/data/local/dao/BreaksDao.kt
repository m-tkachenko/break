package ua.salo.abreak.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ua.salo.abreak.data.local.entity.BreakEntity

/**
 * Represents a Data Access Object (DAO) for interacting with the `breaks` table in the database.
 * This interface defines methods for inserting, retrieving, and querying break data.
 */
@Dao
interface BreaksDao {
    /**
     * Inserts a new `BreakEntity` into the database, replacing any existing entry with the same unique identifier.
     *
     * @param breakEntity The new `BreakEntity` to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBreak(breakEntity: BreakEntity)

    /**
     * Retrieves the most recent `BreakEntity` from the database, ordered by timestamp in descending order.
     *
     * @return The most recent `BreakEntity`, or null if no breaks exist.
     */
    @Query("SELECT * FROM breaks ORDER BY timestamp DESC LIMIT 1")
    suspend fun getLastBreak(): BreakEntity?

    /**
     * Retrieves a specific `BreakEntity` from the database based on its position in the ordered list of breaks.
     *
     * @param position The zero-based position of the desired break.
     * @return The `BreakEntity` at the specified position, or null if the position is invalid or no breaks exist.
     */
    @Query("SELECT * FROM breaks ORDER BY timestamp ASC LIMIT 1 OFFSET :position")
    suspend fun getBreakByNumber(position: Int): BreakEntity?

    /**
     * Retrieves all `BreakEntity` objects from the database, ordered by timestamp in descending order.
     *
     * @return A list of all `BreakEntity` objects, or an empty list if no breaks exist.
     */
    @Query("SELECT * FROM breaks ORDER BY timestamp DESC")
    suspend fun getAllBreaks(): List<BreakEntity>?
}
