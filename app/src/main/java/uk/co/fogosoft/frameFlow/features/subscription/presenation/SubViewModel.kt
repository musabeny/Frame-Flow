package uk.co.fogosoft.frameFlow.features.subscription.presenation

import dagger.hilt.android.lifecycle.HiltViewModel
import uk.co.fogosoft.frameFlow.core.util.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SubViewModel @Inject constructor():BaseViewModel<SubState,SubEvent>() {
    override fun defaultSate(): SubState  = SubState()

    override fun onEvent(event: SubEvent) {
        TODO("Not yet implemented")
    }
}