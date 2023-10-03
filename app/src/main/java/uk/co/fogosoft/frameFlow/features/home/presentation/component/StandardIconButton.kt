package uk.co.fogosoft.frameFlow.features.home.presentation.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.ui.theme.FrameFlowTheme

@Composable
fun StandardIconButton(
    onTap:() -> Unit,
    icon:Int,
    tintColor: Color = MaterialTheme.colorScheme.tertiary,
    size:Dp,
    alpha:Float = 1.0f
){
    IconButton(
        onClick = onTap,
        modifier = Modifier.alpha(alpha)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = tintColor,
            modifier = Modifier.size(size)
        )
    }
}


@Preview
@Composable
fun PreviewStandardIconButton(){
    FrameFlowTheme {
        StandardIconButton(
            onTap = {},
            icon = R.drawable.ic_menu,
            size = 48.dp
        )
    }
}