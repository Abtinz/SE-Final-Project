package com.siliconvalley.bilito.commonServices.compose.actionBar

import android.content.Intent
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.siliconvalley.bilito.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ActionBar(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    title: String,
    //onHomeIconClick : () -> Unit
){
    val context = LocalContext.current
    TopAppBar(
        title = { Text(text = title) } ,
        backgroundColor =  colorResource(id = R.color.primary),
        contentColor = colorResource(id = R.color.onPrimary) ,
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(imageVector = Icons.Filled.Menu
                    , contentDescription = "Drawer Bottom" )
            }
        } ,

        actions = {
            IconButton(onClick = {
                //context.startActivity(Intent(context , FirstPageActivity::class.java))
            }) {
                Icon(painter = painterResource(id =R.drawable. )
                    , contentDescription = "Home"
                    ,modifier = Modifier.size(35.dp))
            }
        }
    )
}