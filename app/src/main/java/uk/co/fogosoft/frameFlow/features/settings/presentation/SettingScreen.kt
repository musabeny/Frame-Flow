package uk.co.fogosoft.frameFlow.features.settings.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.features.common.component.TopHeading
import uk.co.fogosoft.frameFlow.features.settings.presentation.component.Appearance
import uk.co.fogosoft.frameFlow.features.settings.presentation.component.LanguageDropdown
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun SettingScreen(
    state: SettingState,
    onEvent: (SettingEvent) -> Unit = {},
    openDrawer:() -> Unit = {}
){
    val context = LocalContext.current
    LaunchedEffect(key1 = true ){
        if(state.languages.isEmpty()){
            onEvent(SettingEvent.Languages(context))
        }
    }
 Box(modifier = Modifier.fillMaxSize()){
     Column(
         modifier = Modifier.fillMaxSize(),
         verticalArrangement = Arrangement.Top
     ) {
         TopHeading(
             onTapDrawer = openDrawer,
             title = R.string.setting
         )
         LanguageDropdown(
             modifier = Modifier
                 .padding(
                     horizontal = MaterialTheme.dimens.small2,
                 )
                 .padding(top = MaterialTheme.dimens.medium3)
             ,
             languages = state.languages ,
             onEvent = onEvent,
             expanded = state.expanded,
             selected = state.selectedLanguage
         )

         Appearance(
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(top = if (state.expanded) with(LocalDensity.current) { state.dropdownHeight.height.toDp() } else 0.dp)
         )
     }
 }
}