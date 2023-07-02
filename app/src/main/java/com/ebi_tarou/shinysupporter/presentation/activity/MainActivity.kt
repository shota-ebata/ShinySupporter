package com.ebi_tarou.shinysupporter.presentation.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.ebi_tarou.shinysupporter.presentation.AppNavHost
import com.ebi_tarou.shinysupporter.presentation.ShinySupporterTheme
import com.ebi_tarou.shinysupporter.presentation.navigation.AppNavigationActions
import com.ebi_tarou.shinysupporter.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShinySupporterTheme {
                val navController = rememberNavController()
                val navigationActions = remember(navController) {
                    AppNavigationActions(navController)
                }
                AppNavHost(
                    navController = navController,
                    navigateToDetail = { destination ->
                        navigationActions.navigateTo(destination)
                    },
                )
            }
        }
    }
}