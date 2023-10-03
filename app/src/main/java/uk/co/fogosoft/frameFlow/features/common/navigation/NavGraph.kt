package uk.co.fogosoft.frameFlow.features.common.navigation

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import uk.co.fogosoft.frameFlow.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph(){
    val navHostController = rememberNavController()
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val current = navBackStackEntry?.destination?.route
    val viewModel = hiltViewModel<NavigationViewModel>()
    val state = viewModel.state.collectAsState().value

    val topBarScreens = listOf(
        Routes.newProject,
        Routes.albums,
        Routes.drafts
    )
    LaunchedEffect(key1 = current ){
       viewModel.onEvent(NavigationEvent.ScreenTitle(current ?: ""))
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
           if(current in  topBarScreens){
               Log.d("namana","top bar  found")
               TopAppBar(
                   title = { Text(
                       text = stringResource(
                           id = state.title ?: R.string.newProject
                       ),
                       color = MaterialTheme.colorScheme.primary,
                       fontWeight = FontWeight.ExtraBold
                   )
               },
               navigationIcon = {
                   Icon(
                       modifier = Modifier.clickable {
                         viewModel.onEvent(NavigationEvent.PopBackStack(navHostController))
                       },
                       imageVector = Icons.Filled.ArrowBack,
                       contentDescription =null,
                       tint = MaterialTheme.colorScheme.primary
                   )
               }
               )
           }
        }
    ) {
        val padding = it.calculateTopPadding()
        Box(modifier = Modifier.padding(top = padding)) {
            NavHostController(navHostController = navHostController)
        }
    }
}