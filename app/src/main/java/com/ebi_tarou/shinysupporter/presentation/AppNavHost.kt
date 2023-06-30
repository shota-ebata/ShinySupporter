package com.ebi_tarou.shinysupporter.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.ebi_tarou.shinysupporter.presentation.contents.NouhauDetailContent
import com.ebi_tarou.shinysupporter.presentation.contents.NouhauListContent
import com.ebi_tarou.shinysupporter.presentation.navigation.AppRoute

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    navigateToDetail: (nouhauId: Long) -> Unit,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AppRoute.NOUHAU_LIST,
    ) {
        composable(AppRoute.NOUHAU_LIST) {
            NouhauListContent(
                navigateToDetail = navigateToDetail
            )
        }
        composable(AppRoute.NOUHAU_DETAIL) {
            NouhauDetailContent()
        }
    }

}