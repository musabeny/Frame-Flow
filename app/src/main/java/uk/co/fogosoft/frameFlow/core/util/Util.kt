package uk.co.fogosoft.frameFlow.core.util

import androidx.compose.animation.core.Easing
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.features.common.navigation.Routes

fun Easing.transform(from: Float, to: Float, value: Float): Float {
    return transform(((value - from) * (1f / (to - from))).coerceIn(0f, 1f))
}

operator fun PaddingValues.times(value: Float): PaddingValues = PaddingValues(
    top = calculateTopPadding() * value,
    bottom = calculateBottomPadding() * value,
    start = calculateStartPadding(LayoutDirection.Ltr) * value,
    end = calculateEndPadding(LayoutDirection.Ltr) * value
)

fun getIcons(path:String):Int{
   return when(path){
        Routes.setting -> R.drawable.ic_setting
        Routes.info -> R.drawable.ic_help
        Routes.subscription -> R.drawable.ic_shopping_bag
        else -> R.drawable.ic_menu_light
    }
}

fun getToPPadding(path:String,top:Dp):Dp{
    return when(path){
        Routes.setting -> top * 5
        Routes.subscription -> top * 9
        Routes.info -> top * 14
        else -> 0.dp
    }
}

fun showBigIcon(path:String):Boolean{
    return when(path){
        Routes.setting -> true
        Routes.info -> true
        Routes.subscription -> true
        else -> false
    }
}