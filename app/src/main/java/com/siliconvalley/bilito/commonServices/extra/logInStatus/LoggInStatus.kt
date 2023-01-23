package com.siliconvalley.bilito.commonServices.extra.logInStatus

import com.siliconvalley.bilito.profile.db.user.UserDataBase

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoggInStatus:ViewModel() {
    //this boolean key will help us to recognize that if our user logged in or not
    private val _isUserLoggedIn = MutableLiveData<Boolean>()
    val isUserLoggedIn : LiveData<Boolean>
        get() = _isUserLoggedIn

    fun dbCheck(context: Context){
        viewModelScope.launch {
            _isUserLoggedIn.value = UserDataBase(context).getUserDao().getAllUsers().isNotEmpty()
        }
    }
}