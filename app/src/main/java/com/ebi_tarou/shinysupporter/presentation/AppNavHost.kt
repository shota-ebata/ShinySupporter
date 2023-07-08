package com.ebi_tarou.shinysupporter.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ebi_tarou.shinysupporter.presentation.navigation.AppRoute
import com.ebi_tarou.shinysupporter.presentation.navigation.NouhauDetailDestination
import com.ebi_tarou.shinysupporter.presentation.navigation.NouhauDetailDestination.Companion.NOUHAU_ID_KEY
import com.ebi_tarou.shinysupporter.presentation.page.NouhauDetailPage
import com.ebi_tarou.shinysupporter.presentation.page.NouhauListPage

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    navigateToDetail: (NouhauDetailDestination) -> Unit,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AppRoute.NOUHAU_LIST,
    ) {
        composable(AppRoute.NOUHAU_LIST) {
            NouhauListPage(
                navigateToDetail = navigateToDetail
            )
        }
        composable(
            route = AppRoute.NOUHAU_DETAIL,
            arguments = listOf(
                navArgument(NOUHAU_ID_KEY) { type = NavType.LongType }
            )
        ) {
            NouhauDetailPage()
        }
    }
}