package uk.co.fogosoft.frameFlow.features.settings.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.features.settings.domain.model.Languages
import uk.co.fogosoft.frameFlow.features.settings.presentation.SettingEvent
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun LanguageDropdown(
    modifier: Modifier,
    expanded:Boolean = false,
    languages: List<Languages>,
    onEvent:(SettingEvent) -> Unit,
    selected: Languages?
){

    var fieldSize by remember { mutableStateOf(Size.Zero) }

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onEvent(SettingEvent.OpenDropdown)
                }
                .onGloballyPositioned { coordinates ->
                    fieldSize = coordinates.size.toSize()
                },
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small3),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_word),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Text(
                    text = stringResource(id = R.string.language),
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleLarge
                )
            }

            Icon(
                modifier = Modifier.size(MaterialTheme.dimens.medium1),
                painter = painterResource(
                    id = if(expanded) R.drawable.ic_arrow_up else R.drawable.ic_arrow_down),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
        Box(modifier = Modifier){
          Text(
              modifier = Modifier.padding(start = MaterialTheme.dimens.medium3),
              text = selected?.name ?: "",
              color = Color.Black,
              style = MaterialTheme.typography.titleLarge,
              fontWeight = FontWeight.Normal
          )

          DropdownMenu(
              modifier = Modifier
                  .width(with(LocalDensity.current) { fieldSize.width.toDp() })
                  .onGloballyPositioned { coordinates ->
                      val size = coordinates.size.toSize()
                      onEvent(SettingEvent.DropdownHeight(size))
                  },
              expanded = expanded,
              onDismissRequest = {
                  onEvent(SettingEvent.CloseDropdown)
              }) {
              languages.forEach {language ->
                DropdownMenuItem(text = {
                  Row(
                      horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small2)
                  ) {
                      Box(
                          modifier = Modifier
                              .size(MaterialTheme.dimens.medium1)
                              .border(
                                  width = 1.dp,
                                  color = MaterialTheme.colorScheme.primary,
                                  shape = CircleShape
                              )
                              .background(
                                  color =if(selected == language) MaterialTheme.colorScheme.primary else Color.Transparent,
                                  shape = CircleShape
                              )



                      )
                      Text(
                          text = language.name,
                          color = Color.Black,
                          style = MaterialTheme.typography.bodyLarge
                      )

                  }
                }, onClick = {
                  onEvent(SettingEvent.SelectLanguage(language))
                })
              }
          }
        }
    }

}