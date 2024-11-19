package ua.salo.abreak.data.repository

import ua.salo.abreak.data.local.datasource.BreaksLocalDataSource
import ua.salo.abreak.domain.BreaksRepository
import ua.salo.abreak.domain.model.Break
import ua.salo.abreak.utils.MappersUtil.toEntity
import ua.salo.abreak.utils.MappersUtil.toListOfModels
import ua.salo.abreak.utils.MappersUtil.toModel
import javax.inject.Inject

class BreaksRepositoryImpl @Inject constructor(
    private val breaksLocalDataSource: BreaksLocalDataSource
): BreaksRepository {
    override suspend fun addBreak(breakModel: Break) {
        breaksLocalDataSource.insertBreak(breakModel.toEntity())
    }

    override suspend fun getLastBreak(): Break? =
        breaksLocalDataSource.getLastBreak()?.toModel()

    override suspend fun getAllBreaks() =
        breaksLocalDataSource.getAllBreaks()?.toListOfModels()

    override suspend fun getBreakByPosition(position: Int) =
        breaksLocalDataSource.getBreakByPosition(position)?.toModel()

}
