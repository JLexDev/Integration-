package com.jlexdev.prueba.network

import com.jlexdev.prueba.models.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by JLex on 7/16/20
 */
interface ApiService {

    @GET("users")
    fun getUsers(): Call<List<UserResponse>>

    @POST("users")
    fun addNewUser(): Call<UserResponse>

}