package uk.co.fogosoft.frameFlow.features.albums.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.core.util.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor():BaseViewModel<AlbumState,AlbumEvent>() {
    override fun defaultSate(): AlbumState  = AlbumState()

    init {
        onEvent(AlbumEvent.AlbumList)
    }
    override fun onEvent(event: AlbumEvent) {
       when(event){
           is AlbumEvent.AlbumList ->{
               val imgList = listOf(
                   R.drawable.female,
                   R.drawable.female_one,
                   R.drawable.sunset,
                   R.drawable.man_one,
                   R.drawable.female_three,
                   R.drawable.aircraft,
                   R.drawable.war_aircraft,
                   R.drawable.war_car,
                   R.drawable.female,
                   R.drawable.female_three,
                   R.drawable.man_one,
                   R.drawable.female_three,
               )

               _state.update {
                   it.copy(albums = imgList)
               }
           }
       }
    }
}