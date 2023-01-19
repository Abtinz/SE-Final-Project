package com.siliconvalley.bilito.movie.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.siliconvalley.bilito.movie.network.responses.movie.Movie
import java.io.Serializable

@Entity
data class MoviesEntity(
    val movie : Movie
): Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}