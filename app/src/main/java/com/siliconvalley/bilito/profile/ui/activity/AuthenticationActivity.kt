package com.siliconvalley.bilito.profile.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.constraintlayout.motion.widget.Key.VISIBILITY
import com.siliconvalley.bilito.R

class AuthenticationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
    }

    fun loginButton(view: View){

    }

    @SuppressLint("ResourceType")
    fun signUpButton(view: View){
        val loginCardView = findViewById<CardView>(R.id.loginCardView)
        val signUpCardView = findViewById<CardView>(R.id.signUpCardView)
        loginCardView.visibility = View.GONE
        signUpCardView.visibility = View.VISIBLE
    }
}