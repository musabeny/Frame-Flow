package uk.co.fogosoft.frameFlow.features.newProject.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.features.common.component.ImageDetail
import uk.co.fogosoft.frameFlow.core.util.DraftDetails
import uk.co.fogosoft.frameFlow.features.newProject.presentation.NewProjectEvent
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun DraftSection(
    modifier: Modifier,
    firstDraft:List<DraftDetails>,
    secondDraft:List<DraftDetails>,
    onEvent: (NewProjectEvent) -> Unit

){
    Column(
        modifier = modifier,
    ) {
        ImageTitle(
            modifier = Modifier.clickable {
                 onEvent(NewProjectEvent.GoToDraft)
            },
            title = R.string.draft
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small1)
        ) {
         ImageDetail(
             modifier = Modifier
                 .width(180.dp)
                 .fillMaxHeight(),
             size = "03:17",
             duration = "8.7MB",
         )
         Column(
             modifier = Modifier
                 .fillMaxWidth()
                 .fillMaxHeight(),
             verticalArrangement = Arrangement.SpaceBetween
         ) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small1)
            ){
               items(firstDraft){detail ->
                  ImageDetail(
                      modifier = Modifier.size(100.dp),
                      imageId = detail.image,
                      size = detail.size,
                      duration = detail.duration
                  )
               }
            }

             LazyRow(
                 modifier = Modifier.fillMaxWidth(),
                 horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small1)
             ){
                 items(secondDraft){detail ->
                     ImageDetail(
                         modifier = Modifier.size(100.dp),
                         imageId = detail.image,
                         size = detail.size,
                         duration = detail.duration
                     )
                 }
             }
         }   
        }
    }
}

