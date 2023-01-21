package com.siliconvalley.bilito.mainmenu.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.siliconvalley.bilito.mainmenu.ui.viewModel.MainMenuViewModel
import com.siliconvalley.bilito.R
import com.siliconvalley.bilito.cinemalist.ui.screens.CinemaListView
import com.siliconvalley.bilito.commonServices.ui.compose.reload.ReloadView
import com.siliconvalley.bilito.mainmenu.ui.model.screens.BilitoScreens
import com.siliconvalley.bilito.movie.network.responses.movie.Movie

@Composable
fun MainMenu(navController: NavHostController) {
    val viewModel = viewModel(MainMenuViewModel::class.java)
    val latestList = viewModel.latestMovieList.collectAsState()
    val bestList = viewModel.bestMovieList.collectAsState()
    val cinemaList = viewModel.cinemaList.collectAsState()
    val context = LocalContext.current
    LazyColumn{
       item{
            MainMenuTitleCardView()
        }

        //api section
        viewModel.lastestMovieApiDataBase(context)
        viewModel.bestMovieApiDataBase(context)
        viewModel.cinemaListApiDataBase()

        if(latestList.value.isEmpty()){
            item {
                ReloadView()
            }
        }else{

            item{
                Divider(Modifier.padding(10.dp))
                RowMovieView(navController,latestList.value , "Latest Movies:" )
            }
            
        }

        if(bestList.value.isEmpty()){
            item {
                ReloadView()
            }
        }else{
            item {
                RowMovieView(navController,bestList.value , "Best Movies:")
            }
        }

        if(cinemaList.value.isEmpty()){
            item {
                ReloadView()
            }
        }else{
            item {
                Text(
                    "Cinema List:",
                    color = colorResource(id = R.color.onPrimary),
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(5.dp),
                )

                LazyRow{
                    item{
                            CinemaListView(cinemaList.value)
                    }
                }
            }

        }
    }

}

@Composable
fun RowMovieView(navController: NavController,movies : List<Movie> , title : String) {
    Text(title ,
        color = colorResource(id =R.color.onPrimary),
        textAlign = TextAlign.Start,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        modifier = Modifier.padding(5.dp),
    )

    Divider(color = Color.DarkGray , thickness = 0.5.dp , modifier = Modifier.padding(5.dp))
    LazyRow{
        item{
            movies.forEach { movie ->
                MovieCardView(navController ,movieTitle = movie.name, movieUri = movie.picture, movieId = movie.id)
            }
        }
    }
}
@Composable
fun MainMenuTitleCardView() {
    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .height(100.dp),
        elevation = 2.dp,
        shape  = RoundedCornerShape(20.dp) ,
    ){
        Image(painter = painterResource(id = R.drawable.main_menu_image),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun MovieCardView(navController: NavController,movieId:String ,movieTitle :String , movieUri : String) {
    Card(modifier = Modifier
        .padding(10.dp)
        .width(200.dp)
        .height(250.dp)
        .clickable {
            navController.navigate(BilitoScreens.MoviePageRoute.passInfo(movieId))
        }
        .shadow(ambientColor = Color.Gray, elevation = 10.dp),
        shape  = RoundedCornerShape(10.dp) ,
    ){
        Column {
            Image(
                painter = rememberAsyncImagePainter(model = movieUri),
                contentDescription = movieTitle,
                modifier = Modifier
                    .height(210.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Text(
                movieTitle ,
                color = Color.Black,
                textAlign = TextAlign.End,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Italic,
                fontSize = 18.sp,
                modifier = Modifier.padding(5.dp) ,
            )
        }
    }
}