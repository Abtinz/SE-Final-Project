package com.siliconvalley.bilito.mainmenu.ui.model.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.siliconvalley.bilito.cinemalist.ui.screens.CinemaList
import com.siliconvalley.bilito.cinemalist.ui.screens.CinemaPage
import com.siliconvalley.bilito.mainmenu.ui.model.screens.BilitoScreens
import com.siliconvalley.bilito.mainmenu.ui.screens.MainMenu
import com.siliconvalley.bilito.movie.ui.screens.MoviePage

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun SetUpNavigationGraph (navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        startDestination = BilitoScreens.MainMenu.route
    ) {
        composable(route = BilitoScreens.MainMenu.route) {
            MainMenu(navController = navHostController)
        }
        composable(route = BilitoScreens.CinemaPageRoute.route) {
            CinemaPage(navController = navHostController)
        }
        composable(route = BilitoScreens.MainMenu.route) {
            CinemaList(navController = navHostController)
        }
        composable(route = BilitoScreens.MoviePageRoute.route) {
            MoviePage(navController = navHostController)
        }
    }
}