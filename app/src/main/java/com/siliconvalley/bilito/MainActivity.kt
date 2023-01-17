package com.siliconvalley.bilito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.compose.material.ExperimentalMaterialApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.siliconvalley.bilito.mainmenu.ui.activity.MainMenuActivity

class MainActivity : AppCompatActivity() {

    @OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed(this::loadApp, 2000)

    }

    @OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
    fun loadApp(){
        startActivity(Intent(this , MainMenuActivity::class.java))
    }
}