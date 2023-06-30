package com.ebi_tarou.shinysupporter.presentation.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

object AppRoute {
    const val NOUHAU_LIST = "nouhau_list"
    const val NOUHAU_DETAIL = "nouhau_detail"
}

data class AppDestination(
    val route: String,
    val nouhauId: Long
)

class AppNavigationActions(private val navController: NavHostController) {
    fun navigateTo(destination: AppDestination) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
        }
    }
}