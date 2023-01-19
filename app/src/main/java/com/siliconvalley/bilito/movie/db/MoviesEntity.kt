package com.siliconvalley.bilito.movie.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class MoviesEntity(
    @Embedded
    val movie : MovieSimple
): Serializable {
    @PrimaryKey(autoGenerate = true)
    var ids: Int = 0
}