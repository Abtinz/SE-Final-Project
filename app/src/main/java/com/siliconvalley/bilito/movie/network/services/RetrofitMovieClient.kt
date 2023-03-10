package com.siliconvalley.bilito.movie.network.services

import com.siliconvalley.bilito.cinemalist.network.api.service.CinemaApiService
import com.siliconvalley.bilito.commonServices.network.api.utils.ApiUtils
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitMovieClient {
    //moshi converter
    private val moshi =  Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    //retrofit service
    private val retrofit = Retrofit.Builder()
        .baseUrl(ApiUtils.API_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val movieApiService : MovieApiServices by lazy {
        retrofit.create(MovieApiServices::class.java)
    }


}