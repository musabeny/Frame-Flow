package uk.co.fogosoft.frameFlow.features.home.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.ui.theme.FrameFlowTheme
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun BoxIcons(
    modifier: Modifier = Modifier
){

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CustomsBox(
                firstColor = R.color.orange,
                secondColor = R.color.yellow,
                opacity =0.5f,
                modifier = Modifier
                    .size(MaterialTheme.dimens.smallBox)
            )
            CustomsBox(
                firstColor = R.color.orange,
                secondColor = R.color.yellow,
                opacity =0.5f,
                modifier = Modifier
                    .size(MaterialTheme.dimens.smallBox)
            )
            CustomsBox(
                firstColor = R.color.yellow,
                secondColor = R.color.orange,
                opacity =0.5f,
                modifier = Modifier
                    .size(MaterialTheme.dimens.smallBox)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ) {
            CustomsBox(
                firstColor = R.color.orange,
                secondColor = R.color.yellow,
                opacity =0.75f ,
                modifier = Modifier
                    .width(MaterialTheme.dimens.mediumWidthBox)
                    .height(MaterialTheme.dimens.mediumHeightBox)
            )
            CustomsBox(
                firstColor = R.color.yellow,
                secondColor = R.color.orange,
                opacity =0.75f,
                modifier = Modifier
                    .width(MaterialTheme.dimens.mediumWidthBox)
                    .height(MaterialTheme.dimens.mediumHeightBox)
            )
        }
       CustomsBox(
           firstColor = R.color.orange,
           secondColor = R.color.orange,
           opacity =1f,
           modifier = Modifier
               .size(MaterialTheme.dimens.largeBox)
       )
        Box(modifier = Modifier
            .size(MaterialTheme.dimens.circleShape)
            .background(
                shape = CircleShape,
                color = Color.White
            )
        )

        Icon(
            modifier = Modifier.size(MaterialTheme.dimens.innerCircle),
            painter = painterResource(id = R.drawable.subtract),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary

        )

    }
}

@Composable
fun CustomsBox(
    firstColor:Int,
    secondColor:Int,
    opacity:Float,
    modifier: Modifier
){
    Box(
        modifier = modifier
            .background(
                Brush.horizontalGradient(
                    listOf(
                        colorResource(firstColor),
                        colorResource(secondColor)
                    )
                ),
                RoundedCornerShape(MaterialTheme.dimens.small2),
                opacity
            )
    )
}

@Preview(showBackground = true)
@Composable
fun BoxIconsPreview(){
    FrameFlowTheme{
        BoxIcons(
            modifier = Modifier.fillMaxWidth()
        )
    }
}