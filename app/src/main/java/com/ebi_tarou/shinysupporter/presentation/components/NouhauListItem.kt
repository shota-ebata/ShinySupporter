package com.ebi_tarou.shinysupporter.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ebi_tarou.shinysupporter.domain.model.AtamaNouhau
import com.ebi_tarou.shinysupporter.domain.model.Nouhau

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NouhauListItem(
    modifier: Modifier = Modifier,
    nouhau: Nouhau,
    onClickCard: (nouhauId: Long) -> Unit
) {
    Card(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .combinedClickable(
                onClick = {
                    onClickCard(nouhau.id)
                }
            ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = nouhau.name,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Light Mode",
    showBackground = true,
    widthDp = 400
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode",
    widthDp = 400
)
@Composable
fun NouhauListItemPreview() {
    val nouhau = dummyNouhau()
    NouhauListItem(
        nouhau = nouhau,
        onClickCard = {}
    )
}

private fun dummyNouhau() = AtamaNouhau(
    id = 0L,
    name = "name",
    caption = "caption",
    minLevel = 1,
    maxLevel = 5
)