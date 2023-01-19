package com.siliconvalley.bilito.mainmenu.network.api

import com.siliconvalley.bilito.commonServices.network.api.utils.ApiUtils
import com.siliconvalley.bilito.mainmenu.network.api.instance.MainMenuApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitMainMenuService {
    //moshi converter
    private val moshi =  Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    //retrofit service
    private val retrofit = Retrofit.Builder()
        .baseUrl(ApiUtils.API_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val mainMenuApiService : MainMenuApiService by lazy {
        retrofit.create(MainMenuApiService::class.java)
    }
}