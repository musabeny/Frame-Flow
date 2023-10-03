package uk.co.fogosoft.frameFlow.features.newProject.presentation

sealed interface NewProjectEvent{
   object GetImages:NewProjectEvent
   object GetFirstDraft:NewProjectEvent
   object GetSecondDraft:NewProjectEvent
   object GoToDraft:NewProjectEvent
   object GoToAlbum:NewProjectEvent
}