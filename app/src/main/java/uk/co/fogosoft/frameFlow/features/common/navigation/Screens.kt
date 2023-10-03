package uk.co.fogosoft.frameFlow.features.common.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import uk.co.fogosoft.frameFlow.R

sealed class Screens(
    val route:String,
    @StringRes title:Int,
    val icon: ImageVector?
){
    object Home:Screens(
        route = Routes.home,
        title = R.string.home,
        icon = null
    )
    object Setting:Screens(
        route = Routes.setting,
        title = R.string.setting,
        icon = null
    )
    object Info:Screens(
        route = Routes.info,
        title = R.string.info,
        icon = null
    )
    object Subscription:Screens(
        route = Routes.subscription,
        title = R.string.subscription,
        icon = null
    )
}
