package com.siliconvalley.bilito.mainmenu.ui.activity

import com.siliconvalley.bilito.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.siliconvalley.bilito.commonServices.ui.compose.actionBar.ActionBar
import com.siliconvalley.bilito.mainmenu.ui.model.bottomNavigation.BilitoBottomNavigation
import com.siliconvalley.bilito.mainmenu.ui.model.navigation.SetUpNavigationGraph

@ExperimentalPagerApi
@ExperimentalMaterialApi
class MainMenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetUp()
        }
    }

    @ExperimentalPagerApi
    @ExperimentalMaterialApi
    @Composable
    fun SetUp(){
        val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
        val navController = rememberNavController()
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                ActionBar(title = "Shop",false)
            },
            backgroundColor = colorResource(id = R.color.primary),
            bottomBar = {
                BilitoBottomNavigation(navController = navController)
            }
        ){padding ->
            Box(modifier = Modifier.padding(padding)) {
                SetUpNavigationGraph(navHostController = navController)
            }
        }
    }

}