package com.siliconvalley.bilito.movie.network.services

import com.siliconvalley.bilito.movie.network.responses.movie.Message
import com.siliconvalley.bilito.movie.network.responses.movie.Movie
import com.siliconvalley.bilito.movie.network.responses.movie.MovieResponse
import retrofit2.http.*

interface MovieApiServices {

    @GET("movies/{movie_id}/{user_id}")
    suspend fun movieInformation(
        @Path("movie_id") movie_id: String,
        @Path("user_id") user_id: Int
    ): MovieResponse

    @GET("add-ticket/{movie_id}/{user_id}/{cinema_id}")
    suspend fun ticket(
        @Path("movie_id") movie_id: String,
        @Path("user_id") user_id: Int,
        @Path("cinema_id") cinema_id: Int
    ): Message
}