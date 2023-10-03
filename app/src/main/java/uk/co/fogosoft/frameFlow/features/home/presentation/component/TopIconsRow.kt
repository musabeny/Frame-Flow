package uk.co.fogosoft.frameFlow.features.home.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun TopIconsRow(
    modifier: Modifier,
    onTapDrawer: () -> Unit = {},
    onTap:() -> Unit  = {}
){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        StandardIconButton(
            onTap = onTapDrawer,
            icon = R.drawable.ic_menu,
            size = MaterialTheme.dimens.icon
        )
        StandardIconButton(
            onTap = onTap,
            icon = R.drawable.ic_fluent_premium_28_regular,
            size = MaterialTheme.dimens.diamondIcon
        )

    }
}