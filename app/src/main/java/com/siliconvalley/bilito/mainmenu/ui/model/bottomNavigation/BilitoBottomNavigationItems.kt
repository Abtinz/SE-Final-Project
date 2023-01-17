package com.siliconvalley.bilito.mainmenu.ui.model.bottomNavigation


import com.siliconvalley.bilito.R
import com.siliconvalley.bilito.commonServices.ui.compose.bottomNavigation.BottomNavigationItems

data class BilitoBottomNavigationItems(
    val mainMenu: BottomNavigationItems = BottomNavigationItems("Bilito" , R.drawable.ic_baseline_theaters ,"bilito_main_menu"),
    val search: BottomNavigationItems = BottomNavigationItems("Search" , R.drawable.ic_baseline_search ,"cinema_page"), ////////////////////
    val wishList: BottomNavigationItems = BottomNavigationItems("WishList" , R.drawable.ic_baseline_favorite ,"movie"), ////////
    val CinemaList: BottomNavigationItems = BottomNavigationItems("Cinema List" , R.drawable.ic_baseline_movie_scene , "cinema_list"),
)