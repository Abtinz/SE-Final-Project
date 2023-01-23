package com.siliconvalley.bilito.profile.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.motion.widget.Key.VISIBILITY
import com.siliconvalley.bilito.R
import com.siliconvalley.bilito.commonServices.ui.coroutineBased.BaseActivityCoroutineClass
import com.siliconvalley.bilito.databinding.ActivityAuthenticationBinding
import com.siliconvalley.bilito.databinding.ActivityProfileBinding
import com.siliconvalley.bilito.profile.db.user.UserDataBase
import kotlinx.coroutines.launch

class AuthenticationActivity : BaseActivityCoroutineClass() {
    var imageUri: Uri? = null
    val imageProfileView = findViewById<ImageView>(R.id.imageProfileView)
    lateinit var binding: ActivityAuthenticationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun loginButton(view: View){
        val username = binding.usernameInput.editText!!.text
        val password = binding.passwordInput.editText!!.text
        if(password.isNotEmpty() and username.isNotEmpty()){
            launch {
                val dbManager = UserDataBase.invoke(this@AuthenticationActivity).getUserDao()
                var isConformed = false
                dbManager.getAllUsers().forEach {user->
                    if(username.equals(user.username) && password.equals(user.password)){
                        isConformed = true
                        val userCorrect = user
                        dbManager.deleteUser(userCorrect)
                        dbManager.newUser(userCorrect)
                    }
                }
                if(isConformed){
                    startActivity(Intent(this@AuthenticationActivity , ProfileActivity::class.java))
                }else{
                    Toast.makeText(this@AuthenticationActivity,"username or password is not accepted",Toast.LENGTH_SHORT).show()
                }
            }
        }else{
            if(password.isEmpty() and username.isNotEmpty())
                Toast.makeText(this,"please fill password field",Toast.LENGTH_SHORT).show()
            else if(username.isEmpty() and password.isNotEmpty())
                Toast.makeText(this,"please fill username field",Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"please fill username and password fields",Toast.LENGTH_SHORT).show()
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