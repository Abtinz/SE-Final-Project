package com.siliconvalley.bilito.mainmenu.network.api.instance

import com.siliconvalley.bilito.cinemalist.network.api.responses.cinema.Cinema
import com.siliconvalley.bilito.mainmenu.network.response.MainMenuResponse
import retrofit2.http.GET

interface MainMenuApiService {
    @GET("main-menu/")
    suspend fun mainMenu(): MainMenuResponse
}