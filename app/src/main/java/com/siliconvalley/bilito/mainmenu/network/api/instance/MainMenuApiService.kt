package com.siliconvalley.bilito.mainmenu.network.api.instance

import com.siliconvalley.bilito.cinemalist.network.api.responses.cinema.Cinema
import com.siliconvalley.bilito.mainmenu.network.response.MainMenuResponse
import com.siliconvalley.bilito.movie.network.responses.movie.Movie
import retrofit2.http.GET

interface MainMenuApiService {
    @GET("main-menu/")
    suspend fun mainMenu(): MainMenuResponse

    @GET("main-menu/latest-movies")
    suspend fun latestMovie(): List<Movie>
    @GET("main-menu/best-movies")
    suspend fun bestMovie(): List<Movie>
    @GET("main-menu/cinema-lists")
    suspend fun cinemaLists(): List<Cinema>
}