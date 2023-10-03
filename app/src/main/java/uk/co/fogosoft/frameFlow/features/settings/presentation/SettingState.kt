package uk.co.fogosoft.frameFlow.features.settings.presentation

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.Dp
import uk.co.fogosoft.frameFlow.features.settings.domain.model.Languages

data class SettingState(
    val showDrawer:Boolean = false,
    val languages:List<Languages> = emptyList(),
    val expanded:Boolean = false,
    val selectedLanguage:Languages = Languages(1,"English"),
    val dropdownHeight:Size = Size.Zero
)
