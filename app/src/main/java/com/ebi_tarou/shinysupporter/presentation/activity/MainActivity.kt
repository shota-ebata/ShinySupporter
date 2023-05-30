package com.ebi_tarou.shinysupporter.presentation.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ebi_tarou.shinysupporter.presentation.ShinySupporterTheme
import com.ebi_tarou.shinysupporter.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()


    private var unusedValue: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShinySupporterTheme {
                MessageCard(text = "本番でございます")
            }
        }
    }

    @Composable
    fun MessageCard(text: String) {
        Row(modifier = Modifier.padding(4.dp)) {
            Surface(
                tonalElevation = 2.dp,
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = text
                )
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun MainActivityPreview() {
        MessageCard("テキストでございます")
    }
}