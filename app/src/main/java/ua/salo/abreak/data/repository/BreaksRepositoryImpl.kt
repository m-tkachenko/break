package ua.salo.abreak.data.repository

import ua.salo.abreak.data.local.datasource.BreaksLocalDataSource
import ua.salo.abreak.domain.BreaksRepository

class BreaksRepositoryImpl(
    private val breaksLocalDataSource: BreaksLocalDataSource
): BreaksRepository {

}
