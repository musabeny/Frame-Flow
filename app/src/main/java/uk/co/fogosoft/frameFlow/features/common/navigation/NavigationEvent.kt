package uk.co.fogosoft.frameFlow.features.common.navigation

import androidx.navigation.NavHostController

sealed interface NavigationEvent{
    data class PopBackStack(val navController: NavHostController):NavigationEvent
    data class ScreenTitle(val route:String):NavigationEvent
}