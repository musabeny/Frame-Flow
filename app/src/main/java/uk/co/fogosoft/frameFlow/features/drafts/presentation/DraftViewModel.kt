package uk.co.fogosoft.frameFlow.features.drafts.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.core.util.DraftDetails
import uk.co.fogosoft.frameFlow.core.util.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class DraftViewModel @Inject constructor():BaseViewModel<DraftState,DraftEvent>(){
    override fun defaultSate(): DraftState  = DraftState()

    init {
        onEvent(DraftEvent.DraftList)
    }

    override fun onEvent(event: DraftEvent) {
        when(event){
           is DraftEvent.DraftList ->{
               val draftOne = DraftDetails(
                   R.drawable.female,
                   "03:71",
                   "8.7MB"
               )
               val draftTwo = DraftDetails(
                   R.drawable.female,
                   "03:71",
                   "8.7MB"
               )
               val draftThree = DraftDetails(
                   R.drawable.female,
                   "03:71",
                   "8.7MB"
               )
               val draftFour = DraftDetails(
                   R.drawable.female,
                   "03:71",
                   "8.7MB"
               )
               val draftFive = DraftDetails(
                   R.drawable.female,
                   "03:71",
                   "8.7MB"
               )
               val draftSix = DraftDetails(
                   R.drawable.female,
                   "03:71",
                   "8.7MB"
               )
               val draftSeven = DraftDetails(
                   R.drawable.female,
                   "03:71",
                   "8.7MB"
               )
               val draftEight = DraftDetails(
                   R.drawable.female,
                   "03:71",
                   "8.7MB"
               )

               val draftNine = DraftDetails(
                   R.drawable.female,
                   "03:71",
                   "8.7MB"
               )
               val draftTen = DraftDetails(
                   R.drawable.female,
                   "03:71",
                   "8.7MB"
               )

               val ls = ArrayList<DraftDetails>()
               ls.add(draftOne)
               ls.add(draftTwo)
               ls.add(draftThree)
               ls.add(draftFour)
               ls.add(draftFive)
               ls.add(draftSix)
               ls.add(draftSeven)
               ls.add(draftEight)
               ls.add(draftNine)
               ls.add(draftTen)

               _state.update {
                   it.copy(list = ls)
               }

           }
        }
    }
}