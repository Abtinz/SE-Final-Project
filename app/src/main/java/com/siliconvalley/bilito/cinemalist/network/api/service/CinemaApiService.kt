package com.siliconvalley.bilito.cinemalist.network.api.service

import com.siliconvalley.bilito.cinemalist.network.api.responses.cinema.Cinema
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface CinemaApiService {

    @FormUrlEncoded
    @POST("cinema/")
    suspend fun cinemaInformation(
        @Field("cinema_name") cinemaName: String
    ): Cinema

    @GET("cinemalist/")
    suspend fun cinemaList(): List<Cinema>

}