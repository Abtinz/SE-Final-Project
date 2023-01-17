package com.siliconvalley.bilito.profile.db.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
//this class is an entity for user database details
data class User(
    val username:String,
    val email : String ,
    val imageUri : String,
    val phone : String,
    val token:String
    //tickets
    ): Serializable {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}