package com.ebi_tarou.shinysupporter.presentation.contents

import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ebi_tarou.shinysupporter.domain.model.AtamaNouhau
import com.ebi_tarou.shinysupporter.presentation.components.NouhauListItem
import com.ebi_tarou.shinysupporter.presentation.viewmodel.MainUIState

@Composable
fun NouhauListContent(
    uiState: MainUIState,
    modifier: Modifier = Modifier,
    navigateToDetail: (nouhauId: Long, ) -> Unit,
) {
    // Contentの上にScreenを作成した場合、引数からもらうようにしたほうがよいか？
    val lazyListState: LazyListState = rememberLazyListState()

    LazyColumn(
        modifier = modifier,
        state = lazyListState,
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
                    navigateToDetail(nouhauId)
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
    NouhauListContent(
        uiState = MainUIState(
            nouhauList = listOf(
                dummyNouhau()
            )
        ),
        navigateToDetail = {

        }
    )
}

private fun dummyNouhau() = AtamaNouhau(
    id = 0L,
    name = "name",
    caption = "caption",
    minLevel = 1,
    maxLevel = 5
)