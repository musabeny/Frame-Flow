package uk.co.fogosoft.frameFlow.features.settings.presentation

import android.content.Context
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.Dp
import uk.co.fogosoft.frameFlow.features.settings.domain.model.Languages


sealed interface SettingEvent{
   object OpenDropdown:SettingEvent
   object CloseDropdown:SettingEvent
   data class Languages(val context: Context):SettingEvent
   data class SelectLanguage(val languages: uk.co.fogosoft.frameFlow.features.settings.domain.model.Languages):SettingEvent
   data class DropdownHeight(val size: Size):SettingEvent
}