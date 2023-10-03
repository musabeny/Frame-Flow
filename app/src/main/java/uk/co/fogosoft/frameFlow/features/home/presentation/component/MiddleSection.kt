package uk.co.fogosoft.frameFlow.features.home.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun MiddleSection(){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small1)
    ) {
        Box(
            modifier = Modifier
                .wrapContentWidth(),
            contentAlignment = Alignment.CenterEnd
        ){
            Icon(painter = painterResource(id = R.drawable.frame_fl_w),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary
            )
            Icon(
                modifier = Modifier.padding(end = MaterialTheme.dimens.iconPadding),
                painter = painterResource(id = R.drawable.subtract),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary

            )


        }

        BoxIcons()
    }
}