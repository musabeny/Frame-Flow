package uk.co.fogosoft.frameFlow.features.home.presentation.component

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.core.util.times
import uk.co.fogosoft.frameFlow.core.util.transform
import uk.co.fogosoft.frameFlow.features.home.presentation.HomeEvent
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun BottomSection(
    modifier: Modifier,
    onEvent:(HomeEvent) -> Unit,
    isButtonClicked:Boolean
){
//    val alpha: Float by animateFloatAsState(if (isButtonClicked) 0f else 1f, label = "")
    val fabAnimationProgress by animateFloatAsState(
        targetValue = if (isButtonClicked) 1f else 0f,
        animationSpec = tween(
            durationMillis = 1000,
            easing = LinearEasing
        ), label = ""
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
        ) {

            CircularButton(
                modifier = Modifier.
                padding(
                    PaddingValues(
                        end = 100.dp
                    ) * FastOutSlowInEasing.transform(0f, 1.0f, fabAnimationProgress)
                )
                ,
                opacity = LinearEasing.transform(0.2f, 0.7f, fabAnimationProgress),
                label = R.string.New
            ){
               onEvent(HomeEvent.GoToNewProject)
            }
            CircularButton(
                modifier = Modifier.
                padding(
                    PaddingValues(
                        start = 100.dp
                    ) * FastOutSlowInEasing.transform(0f, 1.0f, fabAnimationProgress)
                )
                ,
                opacity = LinearEasing.transform(0.2f, 0.7f, fabAnimationProgress),
                label = R.string.free
            ){

            }



        }
        AnimatedVisibility(visible = !isButtonClicked) {
            IconButton(
                modifier = Modifier
                    .size(MaterialTheme.dimens.buttonCircle)
                    .background(
                        color = MaterialTheme.colorScheme.secondary,
                        shape = CircleShape
                    ),
                onClick = {
                    Log.d("namana","button clicked")
                    onEvent(HomeEvent.AddButton)
                }) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier.size(MaterialTheme.dimens.smallIcon),
                        painter = painterResource(id = R.drawable.plus),
                        contentDescription = "add",
                    )
                }
            }
        }


    }
}

@Composable
fun CircularButton(
    modifier: Modifier,
    label:Int,
    opacity:Float = 1f,
    onClick:() -> Unit
){
    Button(
        modifier = modifier
            .size(MaterialTheme.dimens.buttonCircle),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary.copy(alpha = opacity),
        ),
        shape = CircleShape,
        onClick = onClick,
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = stringResource(id = label),
            color = colorResource(id = R.color.yellow).copy(alpha = opacity) ,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1
        )
    }
}