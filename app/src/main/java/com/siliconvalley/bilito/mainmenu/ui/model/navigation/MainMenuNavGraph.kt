package com.siliconvalley.bilito.mainmenu.ui.model.navigation


import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.accompanist.pager.ExperimentalPagerApi
import com.siliconvalley.bilito.mainmenu.ui.model.screens.BilitoScreens
import com.siliconvalley.bilito.mainmenu.ui.screens.MainMenu

@OptIn(ExperimentalPagerApi::class)
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

    }

}