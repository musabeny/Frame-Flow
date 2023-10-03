package uk.co.fogosoft.frameFlow.features.common.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun ImageDetail(
    modifier: Modifier,
    imageId:Int = R.drawable.sun_ris_big,
    size:String,
    duration:String,
    textStyle: TextStyle = MaterialTheme.typography.bodySmall,
    padding: Dp = MaterialTheme.dimens.small1
){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter
    ){
        Image(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(MaterialTheme.dimens.small2)
                ),
            painter = painterResource(id = imageId),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(bottomStart = MaterialTheme.dimens.small2, bottomEnd = MaterialTheme.dimens.small2)
                )
                .padding(horizontal = padding, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = duration,
                style = textStyle
            )
            Text(
                text = size,
                style = textStyle
            )
        }
    }
}