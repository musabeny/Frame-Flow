package uk.co.fogosoft.frameFlow.features.newProject.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.core.util.UiEvent
import uk.co.fogosoft.frameFlow.core.util.base.BaseViewModel
import uk.co.fogosoft.frameFlow.features.common.navigation.Routes
import uk.co.fogosoft.frameFlow.core.util.DraftDetails
import uk.co.fogosoft.frameFlow.features.newProject.domain.model.ImageResource
import javax.inject.Inject

@HiltViewModel
class NewProjectViewModel @Inject constructor():BaseViewModel<NewProjectState,NewProjectEvent>() {
    override fun defaultSate(): NewProjectState  = NewProjectState()

    init {
        onEvent(NewProjectEvent.GetImages)
        onEvent(NewProjectEvent.GetFirstDraft)
        onEvent(NewProjectEvent.GetSecondDraft)
    }

    override fun onEvent(event: NewProjectEvent) {
        when(event){
            NewProjectEvent.GetImages ->{
                val sectionOne = ImageResource(
                    firstImage = R.drawable.female,
                    secondImage = R.drawable.female_one,
                    thirdImage = R.drawable.female_two
                )
                val sectionTwo = ImageResource(
                    firstImage = R.drawable.sunset,
                    secondImage = R.drawable.landscape,
                    thirdImage = R.drawable.female_three
                )

                val sectionThree = ImageResource(
                    firstImage = R.drawable.landscape,
                    secondImage = R.drawable.female_one,
                    thirdImage = R.drawable.female_three
                )

                val sectionFour = ImageResource(
                    firstImage = R.drawable.female_one,
                    secondImage = R.drawable.sunset,
                    thirdImage = R.drawable.landscape
                )
                val imgList = ArrayList<ImageResource>()
                imgList.add(sectionOne)
                imgList.add(sectionTwo)
                imgList.add(sectionThree)
                imgList.add(sectionFour)
                _state.update {
                    it.copy(images = imgList)
                }
            }
            NewProjectEvent.GetFirstDraft ->{
               val draftOne = DraftDetails(
                   R.drawable.war_car,
                   duration = "03:17",
                   size = "8.7MB"
               )
                val draftTwo = DraftDetails(
                    R.drawable.female_two,
                    duration = "03:17",
                    size = "8.7MB"
                )
                val draftThree = DraftDetails(
                    R.drawable.landscape,
                    duration = "03:17",
                    size = "8.7MB"
                )
                val ls = ArrayList<DraftDetails>()
                ls.add(draftOne)
                ls.add(draftTwo)
                ls.add(draftThree)
                _state.update {
                    it.copy(firstDrafts = ls)
                }
            }
            NewProjectEvent.GetSecondDraft ->{
                val draftOne = DraftDetails(
                    R.drawable.war_aircraft,
                    duration = "03:17",
                    size = "8.7MB"
                )
                val draftTwo = DraftDetails(
                    R.drawable.sunset,
                    duration = "03:17",
                    size = "8.7MB"
                )
                val draftThree = DraftDetails(
                    R.drawable.female,
                    duration = "03:17",
                    size = "8.7MB"
                )
                val ls = ArrayList<DraftDetails>()
                ls.add(draftOne)
                ls.add(draftTwo)
                ls.add(draftThree)
                _state.update {
                    it.copy(secondDraft = ls)
                }
            }
            NewProjectEvent.GoToDraft -> {
                sendEvent(UiEvent.Navigate(Routes.drafts))
            }
            NewProjectEvent.GoToAlbum -> {
                sendEvent(UiEvent.Navigate(Routes.albums))
            }
        }
    }
}