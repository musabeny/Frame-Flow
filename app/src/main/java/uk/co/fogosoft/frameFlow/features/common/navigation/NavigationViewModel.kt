package uk.co.fogosoft.frameFlow.features.common.navigation

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.core.util.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel @Inject constructor():BaseViewModel<NavigationState,NavigationEvent>() {
    override fun defaultSate(): NavigationState = NavigationState()

    override fun onEvent(event: NavigationEvent) {
        when(event){
           is NavigationEvent.PopBackStack -> {
                event.navController.popBackStack()
            }
           is NavigationEvent.ScreenTitle ->{
               _state.update {
                   it.copy(title = when(event.route){
                       Routes.newProject ->{
                           R.string.newProject
                       }
                       Routes.albums ->{
                          R.string.albums
                       }
                       Routes.drafts ->{
                           R.string.draft
                       }
                       else ->{
                           R.string.newProject
                       }
                   })
               }
           }

        }
    }
}