package com.siliconvalley.bilito.mainmenu.ui.model.screens

sealed class BilitoScreens(val route:String){
    object MainMenu : BilitoScreens(route = "bilito_main_menu")
    object CinemaPageRoute : BilitoScreens(route = "cinema_page")
    object CinemaList : BilitoScreens(route = "cinema_list")
    object MoviePageRoute : BilitoScreens(route = "movie")
    object DirectorPage : BilitoScreens(route = "director")
    object ActorPage : BilitoScreens(route = "actor")
}