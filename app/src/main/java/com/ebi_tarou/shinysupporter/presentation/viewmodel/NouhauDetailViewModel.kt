package com.ebi_tarou.shinysupporter.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebi_tarou.shinysupporter.domain.model.Nouhau
import com.ebi_tarou.shinysupporter.domain.repository.NouhauMasterRepository
import com.ebi_tarou.shinysupporter.presentation.navigation.NouhauDetailDestination
import com.ebi_tarou.shinysupporter.presentation.other.SavedStateProperty
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NouhauDetailViewModel
@Inject
constructor(
    private val repository: NouhauMasterRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(State())
    val uiState: StateFlow<State> = _uiState.asStateFlow()

    private val nouhauId: Long by SavedStateProperty(savedStateHandle, key = NouhauDetailDestination::nouhauId.name)

    init {
        fetch(nouhauId)
    }

    private fun fetch(nouhauId: Long) {
        _uiState.value = uiState.value.copy(isLoading = true)
        viewModelScope.launch {
            try {
                delay(1000L)
                val nouhau = repository.getNouhau(nouhauId)
                _uiState.value = uiState.value.copy(nouhau = nouhau, isLoading = false)
            } catch (e: Exception) {
                // TODO: 例外処理
            }
        }
    }

    data class State(
        val nouhau: Nouhau? = null,
        val isLoading: Boolean = false,
    )
}