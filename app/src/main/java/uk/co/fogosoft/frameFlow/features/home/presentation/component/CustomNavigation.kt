package uk.co.fogosoft.frameFlow.features.home.presentation.component

import android.graphics.drawable.Icon
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.core.util.getIcons
import uk.co.fogosoft.frameFlow.core.util.getToPPadding
import uk.co.fogosoft.frameFlow.core.util.showBigIcon
import uk.co.fogosoft.frameFlow.features.common.navigation.Routes
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun CustomNavigation(
    modifier: Modifier = Modifier,
    openHome:() -> Unit = {},
    openSetting:() -> Unit = {},
    openShoppingBag:() -> Unit = {},
    openHelp:() -> Unit = {},
    path:String

){

    Box(modifier = Modifier){
        Column(
            modifier = modifier
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.secondary)
                .padding(horizontal = MaterialTheme.dimens.small2),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small2),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            StandardIconButton(
                onTap = openHome,
                icon = R.drawable.ic_menu_light,
                size = MaterialTheme.dimens.smallIcon,
                tintColor = Color.Unspecified
            )
            StandardIconButton(
                onTap = openSetting,
                icon = R.drawable.ic_setting,
                size = MaterialTheme.dimens.smallIcon,
                tintColor = Color.Unspecified,
                alpha = if(path == Routes.setting)  0f else 1.0f
            )
            StandardIconButton(
                onTap = openShoppingBag,
                icon = R.drawable.ic_shopping_bag,
                size = MaterialTheme.dimens.smallIcon,
                tintColor = Color.Unspecified,
                alpha = if(path == Routes.subscription)  0f else 1.0f
            )

            StandardIconButton(
                onTap = openHelp,
                icon = R.drawable.ic_help,
                size = MaterialTheme.dimens.smallIcon,
                tintColor = Color.Unspecified,
                alpha = if(path == Routes.info) 0f else 1.0f
            )

        }
        AnimatedVisibility(visible = showBigIcon(path)) {
            BigImageIcon(
                modifier = Modifier.padding(
                    start = MaterialTheme.dimens.small2 * 4,
                    top = getToPPadding(path,MaterialTheme.dimens.small2),
                ),
                icon = getIcons(path)
            )
        }

    }

}








@Composable
fun BigImageIcon(
    modifier: Modifier,
    icon: Int
){
    Box(modifier = modifier
        .background(
          color = MaterialTheme.colorScheme.secondary,
          shape = CircleShape
        )){
        Icon(
            modifier = Modifier
                .size(MaterialTheme.dimens.icon)
                .padding(MaterialTheme.dimens.small1),
            painter = painterResource(id = icon) ,
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomNavigationPreview(){
    CustomNavigation(
        modifier = Modifier,
        path = "Setting"
    )
}