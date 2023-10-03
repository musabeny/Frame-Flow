package uk.co.fogosoft.frameFlow.features.home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import uk.co.fogosoft.frameFlow.core.util.UiEvent
import uk.co.fogosoft.frameFlow.core.util.base.BaseViewModel
import uk.co.fogosoft.frameFlow.features.common.navigation.Routes
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor():BaseViewModel<HomeState,HomeEvent>() {
    override fun defaultSate(): HomeState  = HomeState()

    override fun onEvent(event: HomeEvent) {
        when(event){
            is HomeEvent.AddButton ->{
                _state.update {
                   it.copy(addButtonClicked = true)
               }
                closeDrawer()
            }
            is HomeEvent.GoToNewProject ->{
                sendEvent(UiEvent.Navigate(Routes.newProject))
                closeDrawer()
            }
        }
    }
}