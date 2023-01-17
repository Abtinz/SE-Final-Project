package com.siliconvalley.bilito.movie.network.services

import com.siliconvalley.bilito.cinemalist.network.api.responses.cinema.Cinema
import com.siliconvalley.bilito.movie.network.responses.movie.Message
import com.siliconvalley.bilito.movie.network.responses.movie.Movie
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MovieApiServices {
    @FormUrlEncoded
    @POST("movie/")
    suspend fun movieInformation(
        @Field("movie_id") id: String
    ): Movie

    @FormUrlEncoded
    @POST("ticket-selection/")
    suspend fun ticketSelection(
        @Field("movie_id") movieId: String,
        @Field("user_id") userId: String,
    ): Message
}