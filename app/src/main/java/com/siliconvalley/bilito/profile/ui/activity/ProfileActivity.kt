package com.siliconvalley.bilito.profile.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.siliconvalley.bilito.R
import com.siliconvalley.bilito.commonServices.ui.coroutineBased.BaseActivityCoroutineClass
import com.siliconvalley.bilito.databinding.ActivityProfileBinding
import com.siliconvalley.bilito.profile.db.user.UserDataBase
import kotlinx.coroutines.launch

class ProfileActivity : BaseActivityCoroutineClass() {

    lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launch {
            UserDataBase(this@ProfileActivity).getUserDao().getAllUsers().forEach { user ->
                binding.textViewUserName.text = user.username
                binding.textViewEmail.text = user.email
                binding.textViewPhone.text = user.phone
               // binding.textViewTicket.text = user.
            }

        }


    }

    fun imageEditor(view: View){

    }
}