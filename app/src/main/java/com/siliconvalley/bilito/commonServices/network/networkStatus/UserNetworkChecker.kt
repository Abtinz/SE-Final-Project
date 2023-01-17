package com.siliconvalley.bilito.commonServices.network.networkStatus

import android.content.Context
import android.net.ConnectivityManager

/*
 * this class will help us to know user network quality
 */
class UserNetworkChecker(private val context: Context) {
    //here we check users network status
    val checkNetwork :Boolean
        get() {
            //the context connection manager
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            //info about connection
            val networkInformation = connectivityManager.activeNetworkInfo
            return networkInformation != null && networkInformation.isConnected
        }
}