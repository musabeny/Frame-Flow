package uk.co.fogosoft.frameFlow.features.albums.presentation

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.features.albums.presentation.component.AlbumItem
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun AlbumScreen(
    state: AlbumState,
    onEvent: (AlbumEvent) -> Unit
){
    Box(modifier = Modifier.fillMaxSize()){


        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = MaterialTheme.dimens.small3),
            columns = GridCells.Fixed(2) ,
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small1),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small1)
        ){
            items(state.albums){album ->

                AlbumItem(
                    modifier = Modifier.fillMaxWidth(),
                    image = album
                )
            }
        }
    }

}