package ua.salo.abreak.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breaks")
data class BreakEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val content: String,
    val timestamp: Long
)