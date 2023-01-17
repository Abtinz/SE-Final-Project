package com.siliconvalley.bilito.profile.network.api.responses.user

data class UserResponse(
    val username:String,
    val email : String?,
    val imageUri : String?,
    val phone : String,
    val token:String
)
