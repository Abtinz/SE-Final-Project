package com.siliconvalley.bilito.commonServices.network.api.client

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
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


    }
}