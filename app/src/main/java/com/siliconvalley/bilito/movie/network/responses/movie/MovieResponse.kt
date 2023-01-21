package com.siliconvalley.bilito.movie.network.responses.movie

import com.siliconvalley.bilito.cinemalist.network.api.responses.cinema.Cinema
import com.siliconvalley.bilito.profile.network.api.responses.comments.Comments

data class MovieResponse (
    val cinemas : List<Cinema>,
    val director : String ,
    val actors : String ,
    val reviews : List<Comments>
)
