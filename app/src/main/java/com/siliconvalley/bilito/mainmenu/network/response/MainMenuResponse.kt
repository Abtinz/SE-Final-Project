package com.siliconvalley.bilito.mainmenu.network.response

import com.siliconvalley.bilito.cinemalist.network.api.responses.cinema.Cinema
import com.siliconvalley.bilito.movie.network.responses.movie.Movie

data class MainMenuResponse(
    val latestMovies : List<Movie>,
    val bestMovies : List<Movie> ,
    val cinemaList : List<Cinema>
)
