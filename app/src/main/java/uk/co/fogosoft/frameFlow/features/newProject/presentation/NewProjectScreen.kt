package uk.co.fogosoft.frameFlow.features.newProject.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uk.co.fogosoft.frameFlow.features.newProject.presentation.component.AlbumSection
import uk.co.fogosoft.frameFlow.features.newProject.presentation.component.DraftSection
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun NewProjectScreen(
    state: NewProjectState,
    onEvent: (NewProjectEvent) -> Unit
){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
     Column(
         modifier = Modifier
             .fillMaxSize()
             .padding(horizontal = MaterialTheme.dimens.small1),
         verticalArrangement = Arrangement.SpaceEvenly
     ) {
        AlbumSection(
            modifier = Modifier.fillMaxWidth(),
            imgList = state.images,
            onEvent = onEvent
        )
         DraftSection(
             modifier = Modifier
                 .fillMaxWidth()
                 .height(242.dp),
             firstDraft = state.firstDrafts,
             secondDraft = state.secondDraft,
             onEvent = onEvent
         )
     }
    }
}