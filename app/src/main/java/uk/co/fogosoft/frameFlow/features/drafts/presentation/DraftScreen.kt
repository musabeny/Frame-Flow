package uk.co.fogosoft.frameFlow.features.drafts.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uk.co.fogosoft.frameFlow.features.albums.presentation.component.AlbumItem
import uk.co.fogosoft.frameFlow.features.common.component.ImageDetail
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun DraftScreen(
    state: DraftState,
    onEvent: (DraftEvent) -> Unit
){

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = MaterialTheme.dimens.small2)
        .padding(bottom = MaterialTheme.dimens.small1)
    ){
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = MaterialTheme.dimens.small3),
            columns = GridCells.Fixed(2) ,
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small1),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small1)
        ){
            items(state.list){draft ->
                ImageDetail(
                    modifier =Modifier.size(180.dp) ,
                    size = draft.size ,
                    duration = draft.duration,
                    imageId = draft.image)

            }
        }
    }
}