package com.siliconvalley.bilito.commonServices.ui.compose.reload

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.siliconvalley.bilito.R

@Composable
fun ReloadView() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(75.dp) ,
        verticalAlignment = Alignment.CenterVertically
    ){
        CircularProgressIndicator(color = colorResource(id = R.color.onPrimary ) ,
            modifier= Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center)
        )
    }
}