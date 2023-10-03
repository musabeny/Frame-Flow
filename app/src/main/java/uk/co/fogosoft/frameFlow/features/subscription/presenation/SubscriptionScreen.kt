package uk.co.fogosoft.frameFlow.features.subscription.presenation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.features.common.component.TopHeading

@Composable
fun SubscriptionScreen(
    state: SubState,
    onEvent: (SubEvent) -> Unit = {},
    openDrawer:() -> Unit = {}
){
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            TopHeading(
                onTapDrawer = openDrawer,
                title = R.string.subscription
            )
        }
    }
}