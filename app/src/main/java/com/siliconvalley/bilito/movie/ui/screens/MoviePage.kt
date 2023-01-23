package com.siliconvalley.bilito.movie.ui.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.siliconvalley.bilito.R
import com.siliconvalley.bilito.cinemalist.network.api.responses.cinema.Cinema
import com.siliconvalley.bilito.cinemalist.ui.screens.CinemaListView
import com.siliconvalley.bilito.commonServices.ui.compose.reload.ReloadView
import com.siliconvalley.bilito.movie.db.MovieSimple
import com.siliconvalley.bilito.movie.ui.viewMdel.MovieViewModel
import com.siliconvalley.bilito.profile.network.api.responses.comments.Comments

@Composable
fun MoviePage(navController: NavController,movieId:String) {
    val viewModel = viewModel(MovieViewModel::class.java)
    val context = LocalContext.current
    val movieSimpleData by viewModel.movieSimpleInfo.collectAsState()
    val movieExtraData by viewModel.movieInformation.collectAsState()
    viewModel.api(movieId , context)
    LazyColumn{
        if(movieSimpleData.isEmpty()){
            item{
                    ReloadView()
            }
        }else{
            item {
                MovieSimpleView(movieSimpleData[0])
            }
        }

        if(movieExtraData.isEmpty()){
            item{
                ReloadView()
            }
        }else{
            item {
                val movieExtraData = movieExtraData[0]


                    movieExtraData.reviews
                    CastsView(movieExtraData.director, movieExtraData.actors)

                Text(
                    "Screener Cinemas:",
                    color = colorResource(id = R.color.onPrimary),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(10.dp),
                )

                LazyRow {
                    item {
                        CinemaListView(movieExtraData.cinemas)
                    }
                }

                TicketGet(movieExtraData.cinemas,movieId,viewModel)

                Text(
                    "Reviews:",
                    color = colorResource(id = R.color.onPrimary),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(10.dp),
                )

                LazyRow {
                    item {
                        println(movieExtraData.reviews)
                        movieExtraData.reviews.forEach {comment ->
                            CommentsView(comment)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CastsView(director: String, actors: String) {
    Card(border = BorderStroke(2.dp , Color.Gray) ,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .shadow(ambientColor = Color.Gray, elevation = 10.dp),
        shape  = RoundedCornerShape(10.dp)) {
        Column(modifier = Modifier.background(color = Color.Black)){
            Text(
                "Casts:" ,
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp),
            )

            Divider(thickness = 1.dp , color = Color.Gray)

            Text(
                "Director: $director" ,
                color = Color.DarkGray,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                modifier = Modifier.padding(10.dp)
            )

            Text(
                "Actors: $actors" ,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                modifier = Modifier.padding(10.dp)
            )
        }

    }
}

@Composable
fun MovieSimpleView(movieSimpleData: MovieSimple) {

    Row{
       Card(modifier = Modifier
           .weight(2f)
           .padding(10.dp)
           .fillMaxWidth()
           .height(175.dp),
           elevation = 5.dp,
           shape  = RoundedCornerShape(20.dp)){

           Image(painter =  rememberAsyncImagePainter(model = movieSimpleData.picture),
               contentDescription = "",
               modifier = Modifier.fillMaxSize(),
               contentScale = ContentScale.FillBounds
           )
       }
        Column(modifier = Modifier
            .weight(3f)
            .padding(10.dp)
            .fillMaxWidth()
            .height(175.dp)) {

            Text(
                movieSimpleData.name ,
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 5.dp),
            )

            Text(
                "Duration: ${movieSimpleData.length}" ,
                color = Color.Gray,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 5.dp),
            )

            Text(
                "Status: Available!" ,
                color = Color.Gray,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 5.dp),
            )
            Text(
                "(Sponsored by Bilito)" ,
                color = Color.DarkGray,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 5.dp),
            )
        }
    }
}

@Composable
fun CommentsView(comment: Comments) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .width(200.dp)
            .shadow(ambientColor = Color.Gray, elevation = 10.dp)
            .height(200.dp),
        elevation = 5.dp,
        shape  = RoundedCornerShape(10.dp)){

     Column{
          Row{
             Text(
                comment.username ,
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 5.dp),
            )

            Text(
                comment.rate.toString() ,
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 5.dp),
            )
        }

         Divider(thickness = 1.dp , color = Color.Gray)

         Text(
             comment.text ,
             color = Color.DarkGray,
             fontWeight = FontWeight.SemiBold,
             fontSize = 15.sp,
             modifier = Modifier.padding(10.dp),
             maxLines = 6
         )

      }
    }
}


@Composable
fun TicketGet(cinemas: List<Cinema>, movieId: String, viewModel: MovieViewModel) {
    var choosedName = ""
    var choosedCinemaId = -1
    Card(border = BorderStroke(2.dp , Color.Gray) ,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .shadow(ambientColor = Color.Gray, elevation = 10.dp),
        shape  = RoundedCornerShape(10.dp)) {
        Column(modifier = Modifier.background(color = Color.Black)){

            Text(
                "Choose your movie" ,
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp),
            )

            cinemas.forEach { cinema->

                var isCinemaChoosed by remember { mutableStateOf(false) }
                Text(
                    cinema.name ,
                    color = if(isCinemaChoosed)Color.DarkGray else colorResource(id = R.color.onPrimary),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(10.dp).clickable {
                        isCinemaChoosed = true
                        choosedName = cinema.name
                        /////////////
                        choosedCinemaId = cinema.id
                    },
                )
            }

        }

    }

    val context = LocalContext.current
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(20.dp) ,
        elevation =  ButtonDefaults.elevation(
            defaultElevation = 5.dp,
            pressedElevation = 10.dp,
            disabledElevation = 0.dp),
        onClick = {
            if(choosedName == "")
                Toast.makeText( context, "please choose your cinema",Toast.LENGTH_SHORT).show()
            else{
                viewModel.ticket(movieId,choosedCinemaId)
            }
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.onPrimary))){

        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_shopping_cart),
            contentDescription ="",
            tint = colorResource(id = R.color.primary),
            modifier = Modifier.size(30.dp))

        Text(text = "Get your ticket now!",
            Modifier.padding(start = 10.dp) ,
            color = colorResource(id = R.color.primary)
        )
    }
}




