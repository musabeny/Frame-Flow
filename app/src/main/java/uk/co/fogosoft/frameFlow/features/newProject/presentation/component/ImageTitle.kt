package uk.co.fogosoft.frameFlow.features.newProject.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun ImageTitle(
    modifier:Modifier = Modifier,
    title:Int
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small1)
    ) {
        Text(
            text = stringResource(id = title),
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.titleLarge
        )
        Icon(
            imageVector = Icons.Filled.ArrowForward ,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}