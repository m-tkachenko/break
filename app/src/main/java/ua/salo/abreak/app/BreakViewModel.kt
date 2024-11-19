package ua.salo.abreak.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ua.salo.abreak.domain.model.Break
import ua.salo.abreak.domain.usecases.AddNewBreakUseCase
import javax.inject.Inject

@HiltViewModel
class BreakViewModel @Inject constructor(
    private val addNewBreak: AddNewBreakUseCase
): ViewModel() {
    fun addBreak(breakModel: Break) {
        viewModelScope.launch {
            addNewBreak(breakModel).collect {
               it.data
            }
        }
    }
}