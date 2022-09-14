package com.ebatashota.shinysupporter.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor() : ViewModel() {
    fun getText() = "きたわね"
}