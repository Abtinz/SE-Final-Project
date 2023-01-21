package com.siliconvalley.bilito.movie.ui.screens

import androidx.cardview.widget.CardView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.siliconvalley.bilito.R
import com.siliconvalley.bilito.commonServices.ui.compose.reload.ReloadView
import com.siliconvalley.bilito.movie.db.MovieSimple
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
        }else{
            item {
                MovieSimpleView(movieSimpleData[0])
            }
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
           shape  = RoundedCornerShape(20.dp) ){

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