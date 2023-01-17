package com.siliconvalley.bilito.cinemalist.network.api.service

import com.siliconvalley.bilito.commonServices.network.api.utils.ApiUtils.API_BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitCinemaClient {

    //moshi converter
    private val moshi =  Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    //retrofit service
    private val retrofit = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()


}