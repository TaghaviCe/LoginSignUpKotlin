package com.example.loginsignupkotlin.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(

//    @Json(name = "id")
//    val id: Int,
    @Json(name = "username")
    val username: String?,
    @Json(name = "email")
    val email:String?,
    @Json(name = "phone")
    val phone:String?,
    @Json(name = "password")
    val password: String?
   // val response:String
)
