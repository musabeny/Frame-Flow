package uk.co.fogosoft.frameFlow.features.home.presentation

sealed interface HomeEvent{
   object AddButton:HomeEvent
   object GoToNewProject:HomeEvent
}