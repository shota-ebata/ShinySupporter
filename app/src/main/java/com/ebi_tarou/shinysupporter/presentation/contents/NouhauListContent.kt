package com.ebi_tarou.shinysupporter.presentation.contents

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ebi_tarou.shinysupporter.domain.model.AtamaNouhau
import com.ebi_tarou.shinysupporter.presentation.ShinySupporterTheme
import com.ebi_tarou.shinysupporter.presentation.components.NouhauListItem
import com.ebi_tarou.shinysupporter.presentation.navigation.NouhauDetailDestination
import com.ebi_tarou.shinysupporter.presentation.viewmodel.NouhauListUIState

@Composable
fun NouhauListContent(
    modifier: Modifier = Modifier,
    navigateToDetail: (NouhauDetailDestination) -> Unit,
    uiState: NouhauListUIState,
) {
    // Contentの上にScreenを作成した場合、引数からもらうようにしたほうがよいか？
    val lazyListState: LazyListState = rememberLazyListState()

    LazyColumn(
        modifier = modifier,
        state = lazyListState,
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = uiState.nouhauList,
            key = { nouhau ->
                nouhau.id
            },
        ) { nouhau ->
            NouhauListItem(
                modifier = modifier,
                nouhau = nouhau,
                onClickCard = { nouhauId ->
                    navigateToDetail(
                        NouhauDetailDestination(nouhauId)
                    )
                }
            )
        }
    }
}

@Preview(
    name = "Light Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    widthDp = 400,
    heightDp = 400
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode",
    widthDp = 400,
    heightDp = 400
)
@Composable
fun NouhauListContentPreview() {
    ShinySupporterTheme {
        NouhauListContent(
            uiState = NouhauListUIState(
                nouhauList = listOf(
                    dummyNouhau()
                )
            ),
            navigateToDetail = {}
        )
    }
}

private fun dummyNouhau() = AtamaNouhau(
    id = 0L,
    name = "name",
    caption = "caption",
    minLevel = 1,
    maxLevel = 5
)