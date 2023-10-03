package uk.co.fogosoft.frameFlow.features.albums.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun AlbumItem(
    modifier: Modifier,
    image:Int
){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter
    ){
        Image(
            modifier = Modifier
                .size(180.dp)
                .clip(
                    shape = RoundedCornerShape(MaterialTheme.dimens.small3)
                ),
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        Box(modifier = Modifier
            .width(180.dp)
            .fillMaxHeight()
            ,
            contentAlignment = Alignment.BottomStart
        ){
            Text(
                modifier =  Modifier
                    .fillMaxWidth()
                    .clip(
                        shape = RoundedCornerShape(
                            bottomStart = MaterialTheme.dimens.small3,
                            bottomEnd = MaterialTheme.dimens.small3
                        )
                    )
                    .background(
                        color = Color.White.copy(alpha = 0.5f),
                    )

                    .padding(vertical = 4.dp)
                ,
                text = stringResource(id = R.string.screenShoots),
                textAlign = TextAlign.Center
            )
        }

    }
}