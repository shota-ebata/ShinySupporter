package com.ebi_tarou.shinysupporter.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebi_tarou.shinysupporter.domain.model.Nouhau
import com.ebi_tarou.shinysupporter.domain.repository.NouhauMasterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val repository: NouhauMasterRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUIState(loading = true))
    val uiState: StateFlow<MainUIState> = _uiState.asStateFlow()

    init {
        observeNouhaus()
    }

    private fun observeNouhaus() {
        viewModelScope.launch {
            repository.getAllNouhaus()
                .catch {
                    _uiState.value = MainUIState(error = it.message)
                }
                .collect {
                    _uiState.value = MainUIState(nouhauList = it)
                }
        }
    }

}

data class MainUIState(
    val nouhauList: List<Nouhau> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)