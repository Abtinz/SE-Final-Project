package com.siliconvalley.bilito.cinemalist.network.api.responses.cinema

import com.siliconvalley.bilito.movie.network.responses.movie.Movie

data class Cinema(
    private val id :String,
    val title : String ,
    val address : String ,
    val movies : List<Movie> ,
)
