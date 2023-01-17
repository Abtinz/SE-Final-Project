package com.siliconvalley.bilito.cinema.network.api.responses

import com.siliconvalley.bilito.movie.network.responses.movie.Movie

data class Cinema(
    private val id :String,
    val title : String ,
    val address : String ,
    val movies : List<Movie> ,
)
