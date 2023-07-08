package com.ebi_tarou.shinysupporter.presentation.navigation

import androidx.navigation.NavHostController
import com.ebi_tarou.shinysupporter.presentation.navigation.AppRoute.NOUHAU_DETAIL
import com.ebi_tarou.shinysupporter.presentation.navigation.NouhauDetailDestination.Companion.NOUHAU_ID_KEY

object AppRoute {
    const val NOUHAU_LIST = "nouhau_list"
    const val NOUHAU_DETAIL = "nouhau_detail/{${NOUHAU_ID_KEY}}"
}


data class NouhauDetailDestination(
    val nouhauId: Long
) {
    companion object {
        const val NOUHAU_ID_KEY = "nouhauId"
    }
}

class AppNavigationActions(private val navController: NavHostController) {
    fun navigateTo(destination: NouhauDetailDestination) {
        navController.navigate("$NOUHAU_DETAIL/${destination.nouhauId}")
    }
}