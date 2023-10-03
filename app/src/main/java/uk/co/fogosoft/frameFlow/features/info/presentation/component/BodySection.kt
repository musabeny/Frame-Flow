package uk.co.fogosoft.frameFlow.features.info.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.ui.theme.dimens

@Composable
fun BodySection(
    modifier: Modifier
){
   Row(
       modifier = modifier,
   ) {
       Spacer(modifier = Modifier.weight(0.7f))
       Column(
           modifier = Modifier.weight(1f),
           verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small3),
       ) {
           BodyTex(
               modifier = Modifier.fillMaxWidth(),
               text = stringResource(id = R.string.private_policy)
           )
           BodyTex(
               modifier = Modifier.fillMaxWidth(),
               text = stringResource(id = R.string.terms_of_use)
           )
           BodyTex(
               modifier = Modifier.fillMaxWidth(),
               text = stringResource(id = R.string.version)
           )
           BodyTex(
               modifier = Modifier.fillMaxWidth(),
               text = stringResource(id = R.string.company_email)
           )
       }
   }

}

@Composable
fun BodyTex(
    modifier: Modifier,
    text:String
){
   Text(
       modifier = Modifier,
       text = text,
       color = MaterialTheme.colorScheme.secondary,
       style = MaterialTheme.typography.bodyLarge,
//       fontWeight = FontWeight.SemiBold,
       textAlign = TextAlign.Start
   )
}