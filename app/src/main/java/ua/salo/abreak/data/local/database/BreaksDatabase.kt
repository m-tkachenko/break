package ua.salo.abreak.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ua.salo.abreak.data.local.dao.BreaksDao
import ua.salo.abreak.data.local.entity.BreakEntity

@Database(entities = [BreakEntity::class], version = 1)
abstract class BreaksDatabase: RoomDatabase() {
    abstract fun breaksDao(): BreaksDao
}
