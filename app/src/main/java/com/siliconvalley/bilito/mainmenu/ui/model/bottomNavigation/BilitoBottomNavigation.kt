package com.siliconvalley.bilito.mainmenu.ui.model.bottomNavigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.siliconvalley.bilito.R
import com.siliconvalley.bilito.commonServices.ui.compose.bottomNavigation.BottomNavigationItems

@Composable
fun BilitoBottomNavigation(navController: NavController) {
    val bilitoBottomNavigationItems = BilitoBottomNavigationItems()
    val items = listOf(
        bilitoBottomNavigationItems.mainMenu,
        bilitoBottomNavigationItems.search ,
        bilitoBottomNavigationItems.wishList ,
        bilitoBottomNavigationItems.CinemaList
    )

    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination

    Row(
        Modifier.padding(5.dp).fillMaxWidth()
            .background(colorResource(id = R.color.primary)),
        verticalAlignment = Alignment.CenterVertically ,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        items.forEach {item ->
            AddItem(screen = item, currentDestination = currentDestination, navController = navController )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen : BottomNavigationItems,
    currentDestination : NavDestination?,
    navController: NavController
){
    val isItemSelected = currentDestination?.hierarchy?.any {
        it.route ==  screen.route
    } == true

    val boxBackground = if(isItemSelected){
        colorResource(id = R.color.onPrimary)
    }else{
        colorResource(id = R.color.primary)
    }

    val iconTint = if(isItemSelected){
        colorResource(id = R.color.primary)
    }else{
        colorResource(id = R.color.onPrimary)
    }

    Box(modifier = Modifier.clip(CircleShape).background(boxBackground).height(50.dp)
        .clickable(indication = null,
            interactionSource = remember { MutableInteractionSource() }) {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }

    ){
        Row(Modifier.padding(10.dp).clip(CircleShape) ,
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
        ) {

            Icon(painter = painterResource(id = screen.icon),
                contentDescription = screen.title ,
                tint = iconTint,
                modifier = Modifier.size(45.dp)
            )

            AnimatedVisibility(visible =  isItemSelected , modifier =  Modifier.animateContentSize(
                animationSpec = tween(durationMillis = 5)
            )) {
                Text(text = screen.title , color = iconTint)
            }
        }
    }
}