package com.siliconvalley.bilito.movie.network.responses.movie


import com.siliconvalley.bilito.profile.network.api.responses.comments.Comments

data class Movie(
    val id:String,
    val name : String,
    val length : String,
    val picture : String,
     val director : String,
    //val director : List<Director>
    val actors : String ,
    //val actors : List<String>
 val reviews : List<Comments>,
)
