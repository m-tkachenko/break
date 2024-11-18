package ua.salo.abreak.domain

import ua.salo.abreak.domain.model.Break

interface BreaksRepository {
    suspend fun addBreak(breakModel: Break)
    suspend fun getLastBreak(): Break?
    suspend fun getAllBreaks(): List<Break>?
    suspend fun getBreakByPosition(position: Int): Break?
}
