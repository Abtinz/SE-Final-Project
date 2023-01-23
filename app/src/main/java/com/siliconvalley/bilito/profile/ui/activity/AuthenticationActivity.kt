package com.siliconvalley.bilito.profile.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.motion.widget.Key.VISIBILITY
import com.siliconvalley.bilito.R
import com.siliconvalley.bilito.commonServices.ui.coroutineBased.BaseActivityCoroutineClass
import kotlinx.coroutines.launch

class AuthenticationActivity : BaseActivityCoroutineClass() {
    var imageUri: Uri? = null
    val imageProfileView = findViewById<ImageView>(R.id.imageProfileView)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
    }

    fun loginButton(view: View){
        launch {

        }
    }

    @SuppressLint("ResourceType")
    fun signUpButton(view: View){
        val loginCardView = findViewById<CardView>(R.id.loginCardView)
        val signUpCardView = findViewById<CardView>(R.id.signUpCardView)
        loginCardView.visibility = View.GONE
        signUpCardView.visibility = View.VISIBLE
    }

    fun imageEditor(view: View){
        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(gallery, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == 100){
            imageUri = data?.data
            imageProfileView.setImageURI(imageUri)
        }
    }
}