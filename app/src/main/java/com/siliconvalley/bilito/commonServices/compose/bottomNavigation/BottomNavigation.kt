package com.siliconvalley.bilito.commonServices.compose.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavigation() {
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

}