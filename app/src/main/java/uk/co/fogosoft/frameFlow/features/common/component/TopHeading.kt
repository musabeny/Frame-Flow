package uk.co.fogosoft.frameFlow.features.common.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.features.home.presentation.component.StandardIconButton
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun TopHeading(
    onTapDrawer:() -> Unit,
    title:Int
){
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = title),
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )
        StandardIconButton(
            onTap = onTapDrawer,
            icon = R.drawable.ic_menu,
            size = MaterialTheme.dimens.icon
        )

    }
}