package com.siliconvalley.bilito.mainmenu.ui.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siliconvalley.bilito.cinemalist.network.api.responses.cinema.Cinema
import com.siliconvalley.bilito.mainmenu.network.api.RetrofitMainMenuService
import com.siliconvalley.bilito.movie.db.MovieSimple
import com.siliconvalley.bilito.movie.db.MoviesDataBase
import com.siliconvalley.bilito.movie.db.MoviesEntity
import com.siliconvalley.bilito.movie.network.responses.movie.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainMenuViewModel:ViewModel() {
    private val _latestMovieList  = MutableStateFlow(emptyList<Movie>())
    val latestMovieList: StateFlow<List<Movie>>
        get() = _latestMovieList

    private val _bestMovieList  = MutableStateFlow(emptyList<Movie>())
    val bestMovieList: StateFlow<List<Movie>>
        get() = _bestMovieList

    private val _cinemaList  = MutableStateFlow(emptyList<Cinema>())
    val cinemaList: StateFlow<List<Cinema>>
        get() = _cinemaList

    fun lastestMovieApiDataBase(context: Context){
        viewModelScope.launch {
            try{
                val dataBaseManager = MoviesDataBase(context).getMovieDao()
                val retrofitService = RetrofitMainMenuService.mainMenuApiService
                _latestMovieList.value = retrofitService.latestMovie()
                _latestMovieList.value.forEach {movie ->
                    dataBaseManager.newMovie(MoviesEntity(MovieSimple(movie.id , movie.name , movie.length , movie.picture)))
                }
            }catch (exception :Exception){
                exception.printStackTrace()
            }
        }
    }

    fun bestMovieApiDataBase(context: Context){

            viewModelScope.launch {
                try{
                val dataBaseManager = MoviesDataBase(context).getMovieDao()
                val retrofitService = RetrofitMainMenuService.mainMenuApiService
                _bestMovieList.value = retrofitService.bestMovie()
                _bestMovieList.value.forEach {movie ->
                    dataBaseManager.newMovie(MoviesEntity(MovieSimple(movie.id , movie.name , movie.length , movie.picture)))
                 }
                }catch (exception :Exception){
                    exception.printStackTrace()
                }
            }


    }

    fun cinemaListApiDataBase(){
        try{
            viewModelScope.launch {
                val retrofitService = RetrofitMainMenuService.mainMenuApiService
                _cinemaList.value = retrofitService.cinemaLists()
            }
        }catch (exception :Exception){
            exception.printStackTrace()
        }
    }
}