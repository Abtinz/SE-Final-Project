package com.siliconvalley.bilito.movie.network.services

import com.siliconvalley.bilito.movie.network.responses.movie.Message
import com.siliconvalley.bilito.movie.network.responses.movie.Movie
import retrofit2.http.*

interface MovieApiServices {
    @FormUrlEncoded
    @GET("movie/")
    suspend fun movieInformation(
        @Query("movie_id") movie_id: String,
        @Query("user_id") user_id: Int
    ): Movie

    @FormUrlEncoded
    @POST("ticket-selection/")
    suspend fun ticketSelection(
        @Field("movie_id") movieId: String,
        @Field("user_id") userId: String,
    ): Message
}