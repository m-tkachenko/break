package ua.salo.abreak.data.local.datasource

import ua.salo.abreak.data.local.dao.BreaksDao
import ua.salo.abreak.data.local.entity.BreakEntity
import javax.inject.Inject

class BreaksLocalDataSource @Inject constructor(
    private val breaksDao: BreaksDao
) {
    suspend fun insertBreak(breakEntity: BreakEntity) {
        breaksDao.insertBreak(breakEntity)
    }

    suspend fun getLastBreak() =
        breaksDao.getLastBreak()

    suspend fun getAllBreaks() =
        breaksDao.getAllBreaks()

    suspend fun getBreakByPosition(position: Int) =
        breaksDao.getBreakByNumber(position)
}
