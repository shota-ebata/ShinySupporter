package com.ebi_tarou.shinysupporter.presentation.page

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ebi_tarou.shinysupporter.presentation.contents.NouhauListContent
import com.ebi_tarou.shinysupporter.presentation.navigation.NouhauDetailDestination
import com.ebi_tarou.shinysupporter.presentation.viewmodel.NouhauListUIState
import com.ebi_tarou.shinysupporter.presentation.viewmodel.NouhauListViewModel

@Composable
fun NouhauListPage(
    modifier: Modifier = Modifier,
    navigateToDetail: (NouhauDetailDestination) -> Unit,
    viewModel: NouhauListViewModel = hiltViewModel(),
) {

    val uiState: NouhauListUIState by viewModel.uiState.collectAsStateWithLifecycle()

    NouhauListContent(
        modifier = modifier,
        navigateToDetail = navigateToDetail,
        uiState = uiState
    )
}