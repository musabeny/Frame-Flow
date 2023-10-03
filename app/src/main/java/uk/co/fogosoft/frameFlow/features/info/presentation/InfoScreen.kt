package uk.co.fogosoft.frameFlow.features.info.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.features.common.component.TopHeading
import uk.co.fogosoft.frameFlow.features.info.presentation.component.BodySection
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun InfoScreen(
    state: InfoState,
    onEvent: (InfoEvent) -> Unit = {},
    openDrawer:() -> Unit = {}
){
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.medium2)
        ) {
            TopHeading(
                onTapDrawer = openDrawer,
                title = R.string.info
            )
            BodySection(
                modifier = Modifier.wrapContentSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = MaterialTheme.dimens.medium1),
                contentAlignment = Alignment.BottomCenter
            ){
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.fogosoft_ltd),
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}