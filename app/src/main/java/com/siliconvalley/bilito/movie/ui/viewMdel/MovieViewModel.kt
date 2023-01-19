package com.siliconvalley.bilito.movie.ui.viewMdel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siliconvalley.bilito.cinemalist.network.api.service.RetrofitCinemaClient
import com.siliconvalley.bilito.commonServices.network.api.client.BaseRetrofitClientService
import com.siliconvalley.bilito.commonServices.network.api.utils.ApiUtils.API_BASE_URL
import com.siliconvalley.bilito.movie.network.responses.movie.Movie
import com.siliconvalley.bilito.movie.network.services.MovieApiServices
import com.siliconvalley.bilito.movie.network.services.RetrofitMovieClient
import com.siliconvalley.bilito.profile.db.user.UserDataBase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel:ViewModel() {
    private val _selectionResponse = MutableLiveData<String>()
    val ticketSelectionResponse : LiveData<String>
        get() = _selectionResponse

    private val _movieInformation  = MutableStateFlow(emptyList<Movie>())
    val movieInformation: StateFlow<List<Movie>>
        get() = _movieInformation

    fun api(id:String , context : Context){
        viewModelScope.launch {
            try {
                val user =  UserDataBase(context).getUserDao().getAllUsers()[0]
                val authorization = "Token ${user.token}"
                val baseRetrofitClientService = BaseRetrofitClientService("Authorization", authorization , API_BASE_URL)
                val movieApi = baseRetrofitClientService.retrofit.create(MovieApiServices::class.java)
                try{
                    val movieInformationResponse = movieApi.movieInformation(id)
                    _movieInformation.value = listOf(movieInformationResponse)
                }catch (e:Throwable){
                    println(e.message)
                }

            }catch (e:Exception){
                try {
                    _movieInformation.value = listOf(RetrofitMovieClient.movieApiService.movieInformation(id))
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }
    }

    fun ticketOnlineSelection(movieId:String, context :Context){
        viewModelScope.launch {
            try {
                val user =  UserDataBase(context).getUserDao().getAllUsers()[0]
                try {
                    val authorization = "Token ${user.token}"
                    val baseRetrofitClientService = BaseRetrofitClientService("Authorization", authorization , API_BASE_URL)
                    val movieApi = baseRetrofitClientService.retrofit.create(MovieApiServices::class.java)
                    try{
                        val selectionResponse = movieApi.ticketSelection(movieId,user.id.toString())
                        _selectionResponse.value = selectionResponse.response

                    }catch (e:Throwable){
                        println(e.message)
                    }
                }catch (e:Throwable){
                    println(e.message)
                }

            }catch (e:Exception){

            }
        }
    }
}