package uk.co.fogosoft.frameFlow.core.util

sealed interface UiEvent{
    object PopBackStack:UiEvent
    data class Navigate(val route:String):UiEvent
}