package uk.co.fogosoft.frameFlow.core.util.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import uk.co.fogosoft.frameFlow.core.util.UiEvent
import uk.co.fogosoft.frameFlow.features.common.navigation.Routes

abstract class BaseViewModel<State,ScreenEvent>():ViewModel() {

    protected val _state = MutableStateFlow(this.defaultSate())
    val state = _state.asStateFlow()

    protected val _showDrawer = MutableStateFlow(false)
    val showDrawer = _showDrawer.asStateFlow()

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    protected abstract fun defaultSate():State

    abstract fun onEvent(event: ScreenEvent)

    protected fun sendEvent(uiEvent: UiEvent){
        viewModelScope.launch {
           _uiEvent.emit(uiEvent)
        }
    }

    fun openDrawer(){
      _showDrawer.value = true
    }

    fun openSetting(navController: NavHostController){
        navController.popBackStack()
       navController.navigate(Routes.setting){
           launchSingleTop = true
       }

    }
    fun openShoppingBag(navController: NavHostController){
        navController.popBackStack()
        navController.navigate(Routes.subscription){
            launchSingleTop = true
        }
    }
    fun openHelp(navController: NavHostController){
        navController.popBackStack()
        navController.navigate(Routes.info){
            launchSingleTop = true
        }
    }
    fun openHome(navController: NavHostController){
        navController.popBackStack()
        navController.navigate(Routes.home){
            launchSingleTop = true
        }
    }


    fun closeDrawer(){
        _showDrawer.value = false
    }


}