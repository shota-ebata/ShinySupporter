package com.ebi_tarou.shinysupporter.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.ebi_tarou.shinysupporter.domain.repository.NouhauMasterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NouhauDetailViewModel
@Inject
constructor(
    private val repository: NouhauMasterRepository
): ViewModel() {
}