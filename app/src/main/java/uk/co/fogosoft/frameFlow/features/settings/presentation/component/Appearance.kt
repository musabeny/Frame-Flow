package uk.co.fogosoft.frameFlow.features.settings.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun Appearance(
    modifier: Modifier,
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small2)
    ) {
       Row(
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small3)
       ) {
          Icon(
              painter = painterResource(id = R.drawable.appearance),
              contentDescription = null,
              tint = Color.Unspecified
          )
          Text(
              text = stringResource(id = R.string.appearance),
              color = MaterialTheme.colorScheme.secondary,
              style = MaterialTheme.typography.titleLarge,
          )
       }

        Icon(
            painter = painterResource(id = R.drawable.ic_mode_switch_day),
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}