package com.siliconvalley.bilito.commonServices.ui.compose.actionBar

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
    title: String,
    isHomeIcon : Boolean
){
    val painterResource = when(isHomeIcon){
        true -> { painterResource(id =R.drawable.ic_baseline_home )}
        false -> { painterResource(id =R.drawable.ic_baseline_account_circle ) }
    }

    val context = LocalContext.current
    TopAppBar(
        title = { Text(text = title) } ,
        backgroundColor =  colorResource(id = R.color.primary),
        contentColor = colorResource(id = R.color.onPrimary) ,
        actions = {
            IconButton(onClick = {
                //context.startActivity(Intent(context , FirstPageActivity::class.java))
            }) {
                Icon(painter = painterResource
                    , contentDescription = if(isHomeIcon)"Home" else "user profile"
                    ,modifier = Modifier.size(35.dp)
                ,tint = colorResource(id = R.color.onPrimary)
                )
            }
        }
    )
}