package com.ebi_tarou.shinysupporter.presentation.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ebi_tarou.shinysupporter.presentation.ShinySupporterTheme
import com.ebi_tarou.shinysupporter.presentation.contents.NouhauListContent
import com.ebi_tarou.shinysupporter.presentation.viewmodel.MainUIState
import com.ebi_tarou.shinysupporter.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShinySupporterTheme {
                val uiState: MainUIState by viewModel.uiState.collectAsStateWithLifecycle()
                NouhauListContent(
                    uiState = uiState,
                    navigateToDetail = {}
                )
            }
        }
    }
}