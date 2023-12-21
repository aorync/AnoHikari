package com.syntxr.anohikari.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syntxr.anohikari.domain.model.Jozz
import com.syntxr.anohikari.domain.model.Sora
import com.syntxr.anohikari.domain.usecase.AppUseCase
import com.syntxr.anohikari.domain.usecase.QoranUseCase
import com.syntxr.anohikari.domain.utils.SortType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.updateAndGet
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: AppUseCase,
) : ViewModel() {

    val _test = mutableListOf<Sora>()

    private val _state = MutableStateFlow<HomeState?>(null)
    val state = _state.asStateFlow()

    val soras = mutableListOf<Sora>()
    val jozzes = mutableListOf<Jozz>()
    val sorasJozz = mutableListOf<Sora>()

    fun test() {
        viewModelScope.launch {
            val data = useCase.qoranUseCase.getSora()
            _test.addAll(data)
        }
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.GetJozz -> {
                viewModelScope.launch {
                    _state.emit(HomeState.Loading)
                    try {
                        jozzes.addAll(useCase.qoranUseCase.getJozz())
                        _state.update { HomeState.Success }
                    } catch (e: Exception) {
                        _state.update { HomeState.Error(e.message ?: "Unknown Error") }
                    }
                }
            }

            HomeEvent.GetSora -> {
                viewModelScope.launch {
                    _state.emit(HomeState.Loading)
                    try {
                        soras.addAll(useCase.qoranUseCase.getSora())
                        _state.update { HomeState.Success }
                    } catch (e: Exception) {
                        _state.update { HomeState.Error(e.message ?: "Unknown Error") }
                    }
                }
            }

            is HomeEvent.GetSoraJozz -> {
                viewModelScope.launch {
                    _state.emit(HomeState.Loading)
                    try {
                        sorasJozz.addAll(useCase.qoranUseCase.getSoraJozz(event.jozzNo))
                        _state.update { HomeState.Success }
                    } catch (e: Exception) {
                        _state.update { HomeState.Error(e.message ?: "Unknown Error") }
                    }
                }
            }
        }
    }

}

sealed class HomeState {
    data object Loading : HomeState()
    data object Success : HomeState()
    data class Error(val message: String) : HomeState()
}

sealed class HomeEvent {
    data object GetSora : HomeEvent()
    data object GetJozz : HomeEvent()
    data class GetSoraJozz(val jozzNo: Int) : HomeEvent()
}