package com.ebi_tarou.shinysupporter.presentation.page

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ebi_tarou.shinysupporter.presentation.contents.NouhauDetailContent
import com.ebi_tarou.shinysupporter.presentation.viewmodel.NouhauDetailViewModel

@Composable
fun NouhauDetailPage(
    modifier: Modifier = Modifier,
    viewModel: NouhauDetailViewModel = hiltViewModel(),
) {
    val uiState: NouhauDetailViewModel.State by viewModel.uiState.collectAsStateWithLifecycle()
    if (uiState.isLoading) {
        Text(
            modifier = modifier.padding(4.dp),
            color = MaterialTheme.colorScheme.onBackground,
            text = "ローディング"
        )
    } else {
        uiState.nouhau?.let {
            NouhauDetailContent(nouhau = it)
        }
    }

}