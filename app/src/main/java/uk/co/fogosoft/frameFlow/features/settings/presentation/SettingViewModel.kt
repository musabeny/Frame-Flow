package uk.co.fogosoft.frameFlow.features.settings.presentation

import android.util.Log
import androidx.compose.ui.geometry.Size
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.core.util.UiText
import uk.co.fogosoft.frameFlow.core.util.base.BaseViewModel
import uk.co.fogosoft.frameFlow.features.settings.domain.model.Languages
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor() : BaseViewModel<SettingState,SettingEvent>() {
    override fun defaultSate(): SettingState = SettingState()




    override fun onEvent(event: SettingEvent) {
        when(event){
            is SettingEvent.OpenDropdown ->{
               _state.update {
                   it.copy(expanded = true)
               }
            }
            is SettingEvent.CloseDropdown ->{
                _state.update {
                    it.copy(expanded = false)
                }

            }
            is SettingEvent.Languages ->{
                val language1 = Languages(1,UiText.StringResource(R.string.english).asString(event.context))
                val language2 = Languages(2,UiText.StringResource(R.string.spanish).asString(event.context))
                val language3 = Languages(3,UiText.StringResource(R.string.german).asString(event.context))
                val language4 = Languages(4,UiText.StringResource(R.string.french).asString(event.context))
                val language5 = Languages(5,UiText.StringResource(R.string.russian).asString(event.context))
                val language6 = Languages(6,UiText.StringResource(R.string.turkish).asString(event.context))
                val list = ArrayList<Languages>()
                list.add(language1)
                list.add(language2)
                list.add(language3)
                list.add(language4)
                list.add(language5)
                list.add(language6)
                _state.update {
                    it.copy(languages = list )
                }
            }
            is SettingEvent.SelectLanguage ->{
                _state.update {
                    it.copy(selectedLanguage = event.languages)
                }

                onEvent(SettingEvent.CloseDropdown)
                onEvent(SettingEvent.DropdownHeight(Size.Zero))

            }
            is SettingEvent.DropdownHeight ->{
                _state.update {
                    it.copy(dropdownHeight = event.size)
                }
            }
        }
    }
}