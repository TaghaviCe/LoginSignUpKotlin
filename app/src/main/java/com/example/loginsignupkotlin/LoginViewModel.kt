package com.example.loginsignupkotlin

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginsignupkotlin.repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    fun loginUser(email:String, password: String){
        val userRepository= UserRepository()
        viewModelScope.launch {
            try {
                userRepository.LoginUser(email, password)
            }catch (e:Exception){
                Log.i("errorViewModel","errorViewModel")
            }
        }
    }
}