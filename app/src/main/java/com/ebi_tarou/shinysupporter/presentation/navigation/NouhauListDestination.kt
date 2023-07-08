package com.ebi_tarou.shinysupporter.presentation.navigation

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument

object NouhauListDestination {
    const val baseRoute = "nouhau_list"
}


data class NouhauDetailDestination(
    val nouhauId: Long
) {
    fun createRoute(): String {
        return baseRoute.replace("{${NouhauDetailDestination::nouhauId.name}}", nouhauId.toString())
    }

    companion object {
        val baseRoute = "nouhau_detail/{${NouhauDetailDestination::nouhauId.name}}"
        val arguments = listOf(
            navArgument(NouhauDetailDestination::nouhauId.name) { type = NavType.LongType }
        )
    }
}

class AppNavigationActions(private val navController: NavHostController) {
    fun navigateTo(destination: NouhauDetailDestination) {
        navController.navigate(destination.createRoute())
    }
}