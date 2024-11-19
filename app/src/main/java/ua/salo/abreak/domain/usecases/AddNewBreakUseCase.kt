package ua.salo.abreak.domain.usecases

import kotlinx.coroutines.flow.flow
import ua.salo.abreak.common.Resource
import ua.salo.abreak.domain.BreaksRepository
import ua.salo.abreak.domain.model.Break
import javax.inject.Inject

class AddNewBreakUseCase @Inject constructor(
    private val repository: BreaksRepository
) {
    operator fun invoke(
        breakModel: Break
    ) = flow<Resource<Boolean>> {
        try {
            emit(Resource.Loading())

            repository.addBreak(breakModel)

            emit(Resource.Success(data = true))
        } catch (e: Exception) {
            emit(Resource.Failure(message = e.message))
        }
    }
}