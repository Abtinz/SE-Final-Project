package com.siliconvalley.bilito.movie.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.siliconvalley.bilito.commonServices.ui.compose.reload.ReloadView
import com.siliconvalley.bilito.movie.ui.viewMdel.MovieViewModel

@Composable
fun MoviePage(navController: NavController,movieId:String) {
    val viewModel = viewModel(MovieViewModel::class.java)
    val context = LocalContext.current
    val movieSimpleData by viewModel.movieSimpleInfo.collectAsState()
    viewModel.api(movieId , context)
    LazyColumn{
        if(movieSimpleData.isEmpty()){
            item{
                    ReloadView()
            }
        }
    }

}