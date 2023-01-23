package com.siliconvalley.bilito.commonServices.ui.compose.actionBar

import android.content.Intent
import androidx.compose.foundation.layout.size
import androidx.compose.material.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import com.siliconvalley.bilito.R
import com.siliconvalley.bilito.commonServices.extra.logInStatus.LoggInStatus
import com.siliconvalley.bilito.profile.ui.activity.AuthenticationActivity
import com.siliconvalley.bilito.profile.ui.activity.ProfileActivity
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
    val lifecycleOwner = LocalLifecycleOwner.current
    val viewModel = viewModel(LoggInStatus::class.java)
    TopAppBar(
        title = { Text(text = title) } ,
        backgroundColor =  colorResource(id = R.color.primary),
        contentColor = colorResource(id = R.color.onPrimary) ,
        actions = {
            IconButton(onClick = {
                if(!isHomeIcon)
                {
                    viewModel.dbCheck(context)
                    var init = 0
                    viewModel.isUserLoggedIn.observe(lifecycleOwner, Observer {
                        if(it and (init == 0)){
                            context.startActivity(Intent(context , ProfileActivity::class.java))
                            init = 1
                        }else if(!it and (init == 0)){
                            context.startActivity(Intent(context , AuthenticationActivity::class.java))
                            init = 1
                        }
                    })

                }else{

                }

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