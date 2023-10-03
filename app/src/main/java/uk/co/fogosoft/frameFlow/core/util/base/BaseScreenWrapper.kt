package uk.co.fogosoft.frameFlow.core.util.base

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import uk.co.fogosoft.frameFlow.R
import uk.co.fogosoft.frameFlow.core.util.UiEvent
import uk.co.fogosoft.frameFlow.features.home.presentation.component.CustomNavigation

@Composable
fun<State,ScreenEvent> BaseScreenWrapper(
    navController: NavHostController,
    viewModel: BaseViewModel<State,ScreenEvent>,
    showNavigation:Boolean = false,
    content:@Composable () -> Unit
){
val drawer = viewModel.showDrawer.collectAsState().value

    LaunchedEffect(key1 = true ){
        viewModel.uiEvent.collect{event ->
          when(event){
              is UiEvent.PopBackStack ->{
                  navController.popBackStack()
              }
              is UiEvent.Navigate ->{

                  navController.navigate(event.route)
              }
          }
        }
    }
   Box(
       modifier = Modifier
           .fillMaxSize()
           .clickable {
               viewModel.closeDrawer()
           }
           .background(
               Brush.verticalGradient(
                   listOf(
                       colorResource(R.color.white),
                       colorResource(R.color.light_orange)
                   )
               )
           ),
       contentAlignment = Alignment.TopStart
   ){
       content()
       AnimatedVisibility(
           visible = drawer,
           enter = slideInHorizontally(),
           exit = slideOutHorizontally()
       ) {
           CustomNavigation(
               modifier = Modifier.fillMaxHeight(),
               openHome = {
                   viewModel.openHome(navController)
               },
               openHelp = {
                   viewModel.openHelp(navController)

               },
               openShoppingBag = {
                   viewModel.openShoppingBag(navController)
               },
               openSetting = {
                   viewModel.openSetting(navController)
               },
               path = navController.currentBackStackEntry?.destination?.route ?: ""
           )
       }

   }


}