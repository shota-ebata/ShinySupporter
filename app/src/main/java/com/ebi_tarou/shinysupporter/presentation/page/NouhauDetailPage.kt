package com.ebi_tarou.shinysupporter.presentation.page

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ebi_tarou.shinysupporter.presentation.contents.NouhauDetailContent
import com.ebi_tarou.shinysupporter.presentation.viewmodel.NouhauDetailViewModel

@Composable
fun NouhauDetailPage(
    modifier: Modifier = Modifier,
    viewModel: NouhauDetailViewModel = hiltViewModel(),
) {
    NouhauDetailContent()
}