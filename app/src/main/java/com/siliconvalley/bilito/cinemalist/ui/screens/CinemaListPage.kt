package com.siliconvalley.bilito.cinemalist.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.siliconvalley.bilito.R
import com.siliconvalley.bilito.cinemalist.network.api.responses.cinema.Cinema
import com.siliconvalley.bilito.commonServices.ui.compose.reload.ReloadView
import com.siliconvalley.bilito.mainmenu.ui.viewModel.MainMenuViewModel

@Composable
fun CinemaListPage(navController: NavController){
    val viewModel = viewModel(MainMenuViewModel::class.java)
    val cinemaList = viewModel.cinemaList.collectAsState()
    val context = LocalContext.current
    LazyColumn{
        viewModel.cinemaListApiDataBase()
        if(cinemaList.value.isEmpty()){
            item {
                ReloadView()
            }
        }else{
            item {
                Text(
                    "Hollywood:",
                    color = colorResource(id = R.color.onPrimary),
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(5.dp),
                )
                        CinemaListView(cinemaList.value)
                }
            }

    }
}


@Composable
fun CinemaListView(cinemas: List<Cinema>) {
        cinemas.forEach {
            CinemaCardView(it)
        }
}


@Composable
fun CinemaCardView(cinema: Cinema) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .width(400.dp)
            .height(150.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(10.dp),
    ) {
        Row {
            Image(
                painter = rememberAsyncImagePainter(model = cinema.picture),
                contentDescription = "",
                modifier = Modifier
                    .weight(3f)
                    .fillMaxWidth().fillMaxHeight(),
                contentScale = ContentScale.Fit
            )

            Column(modifier = Modifier.padding(5.dp).weight(2f)){
                Text(
                    cinema.name,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(5.dp)
                )

                Text(
                    cinema.address,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(5.dp),
                    maxLines = 2 ,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }
}

