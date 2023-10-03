package uk.co.fogosoft.frameFlow.features.common.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uk.co.fogosoft.frameFlow.core.util.base.BaseScreenWrapper
import uk.co.fogosoft.frameFlow.features.albums.presentation.AlbumScreen
import uk.co.fogosoft.frameFlow.features.albums.presentation.AlbumViewModel
import uk.co.fogosoft.frameFlow.features.drafts.presentation.DraftScreen
import uk.co.fogosoft.frameFlow.features.drafts.presentation.DraftViewModel
import uk.co.fogosoft.frameFlow.features.home.presentation.HomeScreen
import uk.co.fogosoft.frameFlow.features.home.presentation.HomeViewModel
import uk.co.fogosoft.frameFlow.features.info.presentation.InfoScreen
import uk.co.fogosoft.frameFlow.features.info.presentation.InfoViewModel
import uk.co.fogosoft.frameFlow.features.newProject.presentation.NewProjectScreen
import uk.co.fogosoft.frameFlow.features.newProject.presentation.NewProjectViewModel
import uk.co.fogosoft.frameFlow.features.settings.presentation.SettingScreen
import uk.co.fogosoft.frameFlow.features.settings.presentation.SettingViewModel
import uk.co.fogosoft.frameFlow.features.subscription.presenation.SubViewModel
import uk.co.fogosoft.frameFlow.features.subscription.presenation.SubscriptionScreen

@Composable
fun NavHostController(
     navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        startDestination = Routes.home
    ){

        composable(route = Routes.home){
            val viewModel = hiltViewModel<HomeViewModel>()
            val state = viewModel.state.collectAsState().value

            BaseScreenWrapper(
                navController = navHostController,
                viewModel = viewModel,
                showNavigation = true
            ) {
                HomeScreen(
                    state = state,
                    onEvent = viewModel::onEvent,
                    openDrawer = viewModel::openDrawer
                )
            }

        }
        composable(route = Routes.setting){
            val viewModel = hiltViewModel<SettingViewModel>()
            val state = viewModel.state.collectAsState().value

            BaseScreenWrapper(
                navController = navHostController,
                viewModel = viewModel,
                showNavigation = true
            ) {
                SettingScreen(
                    state = state,
                    onEvent = viewModel::onEvent,
                    openDrawer = viewModel::openDrawer
                )
            }

        }
        composable(route = Routes.info){
            val viewModel = hiltViewModel<InfoViewModel>()
            val state = viewModel.state.collectAsState().value

            BaseScreenWrapper(
                navController = navHostController,
                viewModel = viewModel,
                showNavigation = true
            ) {
                InfoScreen(
                    state = state,
                    onEvent = viewModel::onEvent,
                    openDrawer = viewModel::openDrawer
                )
            }

        }
        composable(route = Routes.subscription){
            val viewModel = hiltViewModel<SubViewModel>()
            val state = viewModel.state.collectAsState().value

            BaseScreenWrapper(
                navController = navHostController,
                viewModel = viewModel,
                showNavigation = true
            ) {
                SubscriptionScreen(
                    state = state,
                    onEvent = viewModel::onEvent,
                    openDrawer = viewModel::openDrawer
                )
            }

        }
        composable(route = Routes.newProject){
            val viewModel = hiltViewModel<NewProjectViewModel>()
            val state = viewModel.state.collectAsState().value

            BaseScreenWrapper(
                navController = navHostController,
                viewModel = viewModel,
                showNavigation = false
            ) {
                NewProjectScreen(
                    state = state,
                    onEvent = viewModel::onEvent
                )
            }

        }

        composable(route = Routes.albums){
            val viewModel = hiltViewModel<AlbumViewModel>()
            val state = viewModel.state.collectAsState().value

            BaseScreenWrapper(
                navController = navHostController,
                viewModel = viewModel,
                showNavigation = false
            ) {
                AlbumScreen(
                    state = state,
                    onEvent = viewModel::onEvent
                )
            }

        }

        composable(route = Routes.drafts){
            val viewModel = hiltViewModel<DraftViewModel>()
            val state = viewModel.state.collectAsState().value

            BaseScreenWrapper(
                navController = navHostController,
                viewModel = viewModel,
                showNavigation = false
            ) {
                DraftScreen(
                    state = state,
                    onEvent = viewModel::onEvent
                )
            }

        }

    }
}