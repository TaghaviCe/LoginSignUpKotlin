package com.example.loginsignupkotlin

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginsignupkotlin.repository.UserRepository
import kotlinx.coroutines.launch

class SignUpViewModel: ViewModel() {
   fun signUp(id:Int,username:String,email:String,phone:String,password:String){
        val userRepository= UserRepository()
       viewModelScope.launch {
           try {
               userRepository.registerUser(id, username, email, phone, password)
           }catch (e:Exception){
               Log.i("errorViewModel","errorViewModel")
           }
       }

    }
}