package uk.co.fogosoft.frameFlow.features.home.presentation

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.PreviewActivity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.features.home.presentation.component.BottomSection
import uk.co.fogosoft.frameFlow.features.home.presentation.component.BoxIcons
import uk.co.fogosoft.frameFlow.features.home.presentation.component.CustomNavigation
import uk.co.fogosoft.frameFlow.features.home.presentation.component.MiddleSection
import uk.co.fogosoft.frameFlow.features.home.presentation.component.StandardIconButton
import uk.co.fogosoft.frameFlow.features.home.presentation.component.TopIconsRow
import uk.co.fogosoft.frameFlow.ui.theme.FrameFlowTheme
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun HomeScreen(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
    openDrawer:() -> Unit = {}
){
    Box(
        modifier = Modifier
            .fillMaxSize()
        ,
        contentAlignment = Alignment.TopStart
    ){

        Column(
            modifier = Modifier
                .fillMaxSize()
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TopIconsRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MaterialTheme.dimens.small1),
                onTapDrawer = openDrawer
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                MiddleSection()

                BottomSection(
                    modifier = Modifier.fillMaxWidth(),
                    onEvent = onEvent,
                    isButtonClicked = state.addButtonClicked
                )


            }




        }
    }
}




@Preview(
    showBackground = true,
)
@Composable
fun HomeScreenPreview(){
    HomeScreen(
        state = HomeState(),
        onEvent = {}
    )


}