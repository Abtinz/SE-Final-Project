package com.siliconvalley.bilito.profile.network.api.responses.comments

data class Comments(
    private val id : String,
    val username : String ,
    val data : String ,
    val rate : Double? ,
    val text : Double ,
)
