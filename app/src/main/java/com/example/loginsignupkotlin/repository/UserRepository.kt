package com.example.loginsignupkotlin.repository

import android.util.Log
import com.example.loginsignupkotlin.model.User
import com.example.loginsignupkotlin.network.UserApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserRepository {
   suspend fun registerUser(id:Int,username:String,email:String,phone:String,password:String){
       val call: Call<User?>? =  UserApi.retrofitService.RegisterAccount(username,email,phone,password)
       call?.enqueue(object : Callback<User?> {
           override fun onResponse(call: Call<User?>, response: Response<User?>) {
               val statusCode = response.code()
               val user = response.body()
               Log.i("ok","$statusCode")
           }

           override fun onFailure(call: Call<User?>, t: Throwable) {
               val statusCode = t.message
               Log.i("errorrrr","$statusCode")
               // Log error here since request failed
           }
       })

    }

    suspend fun LoginUser(email:String,password: String){
      //  UserApi.retrofitService.LoginAccount(email,password)

        val call: Call<User?>? = UserApi.retrofitService.LoginAccount(email,password)
        call?.enqueue(object : Callback<User?> {
            override fun onResponse(call: Call<User?>, response: Response<User?>) {
                val statusCode = response.code()
                val user = response.body()
                Log.i("ok","$statusCode")
            }

            override fun onFailure(call: Call<User?>, t: Throwable) {
                val statusCode = t.message
                Log.i("errorrrrrr","$statusCode")
                // Log error here since request failed
            }
        })
    }
}