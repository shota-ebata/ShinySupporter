package com.ebi_tarou.shinysupporter.presentation.contents

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ebi_tarou.shinysupporter.domain.model.AtamaNouhau
import com.ebi_tarou.shinysupporter.domain.model.Nouhau
import com.ebi_tarou.shinysupporter.presentation.ShinySupporterTheme

@Composable
fun NouhauDetailContent(
    modifier: Modifier = Modifier,
    nouhau: Nouhau,
) {
    Column(
        modifier = modifier.padding(4.dp)
    ) {
        Text(
            modifier = modifier.padding(4.dp),
            color = MaterialTheme.colorScheme.onBackground,
            text = nouhau.name
        )
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
fun NouhauDetailContentPreview() {
    ShinySupporterTheme {
        val dummy = AtamaNouhau(
            id = 0L,
            name = "dummy",
            caption = "dummy",
            minLevel = 1,
            maxLevel = 5
        )
        NouhauDetailContent(nouhau = dummy)
    }
}