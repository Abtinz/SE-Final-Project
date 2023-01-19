package com.siliconvalley.bilito.movie.db

import androidx.room.Query
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

/*
 * this is our dao class which will help us to implements data base and its data interactions with simple queries
 */
@Dao
interface MovieDao {

    /*
     * this function is going to use in log in and sign up sections
     * which will save our new Movie data
     */
    @Insert
    suspend fun newMovie(movie: MoviesEntity)

    @Update
    /*
     * this function will update our Movie edited information
     */
    suspend fun editMovie(movie: MoviesEntity)

    /*
     * this function will delete Movie details after logout or delete account
     */
    @Delete
    suspend fun deleteMovie(movie: MoviesEntity)

    @Query("SELECT * FROM moviesentity")
    suspend fun getAllMovies():List<MoviesEntity>

}