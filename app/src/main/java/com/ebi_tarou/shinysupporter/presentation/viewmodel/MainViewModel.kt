package com.ebi_tarou.shinysupporter.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebi_tarou.shinysupporter.infra.repository.NouhauNoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val repo: NouhauNoteRepository
) : ViewModel() {
    fun getText() = "きたわね"

    fun hoge() {
        viewModelScope.launch {
            repo.getAll()
        }
    }
}