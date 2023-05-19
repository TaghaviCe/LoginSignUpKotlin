package com.example.loginsignupkotlin.network

import com.example.loginsignupkotlin.model.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

import retrofit2.http.POST
import retrofit2.http.Query


val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

val client = OkHttpClient.Builder()
    .addInterceptor(logger)
    .build()

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val apiParameter=ApiParam()

val retrofit= Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(apiParameter.BASE_URL)
    .client(client)
    .build()

interface ApiService {
    @POST("register.php")
    fun RegisterAccount(
        //@Query("id") id:Int?,
        @Query("username") username: String?,
        @Query("email") email: String?,
        @Query("phone") phone: String?,
        @Query("password") password: String?
    ): Call<User?>?


    @GET("login.php")
    fun LoginAccount(
        @Query("email") email: String?,
        @Query("password") password: String?
    ): Call<User?>?
}
object UserApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}