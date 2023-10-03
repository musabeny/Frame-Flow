package uk.co.fogosoft.frameFlow.features.info.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import uk.co.fogosoft.frameFlow.core.util.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor():BaseViewModel<InfoState,InfoEvent>() {
    override fun defaultSate(): InfoState  = InfoState()

    override fun onEvent(event: InfoEvent) {
        TODO("Not yet implemented")
    }
}