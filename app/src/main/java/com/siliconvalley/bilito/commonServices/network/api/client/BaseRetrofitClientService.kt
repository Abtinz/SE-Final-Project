package com.siliconvalley.bilito.commonServices.network.api.client

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit

//this class will help us to have header via token passing
//header title like Authorization and url for basic url of api
class BaseRetrofitClientService(headerTitle: String , headerText:String , url :String) {
    lateinit var retrofit: Retrofit
    init{
        //this is our convertor (moshi)
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        // this section will make a client for our api which can have a header for our tokens
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val requestBuilder = originalRequest.newBuilder()
                    .addHeader(headerTitle, headerText)
                    .method(originalRequest.method,originalRequest.body)
                chain.proceed(requestBuilder.build())
            }.build()
    }
}