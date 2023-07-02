package com.ebi_tarou.shinysupporter.presentation.navigation

import androidx.navigation.NavHostController
import com.ebi_tarou.shinysupporter.presentation.navigation.AppRoute.NOUHAU_DETAIL

object AppRoute {
    const val NOUHAU_LIST = "nouhau_list"
    const val NOUHAU_DETAIL = "nouhau_detail"
}


data class NouhauDetailDestination(
    val nouhauId: Long
)

class AppNavigationActions(private val navController: NavHostController) {
    fun navigateTo(destination: NouhauDetailDestination) {
        navController.navigate(NOUHAU_DETAIL)
    }
}