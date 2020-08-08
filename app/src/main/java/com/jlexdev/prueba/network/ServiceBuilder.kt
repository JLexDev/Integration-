package com.jlexdev.prueba.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by JLex on 7/16/20
 */
object ServiceBuilder {

    // URL
    private const val URL = "https://reqres.in/api/"

    // TODO: Create Logger
    //private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    // TODO: Replace with:
    //private val okHttp = OkHttpClient.Builder().addInterceptor(logger)

    // OkHttp Client
    private val okHttp = OkHttpClient.Builder()


    // Retrofit Builder
    private val builder = Retrofit.Builder().baseUrl(URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(okHttp.build())

    // Retrofit Instance
    private val retrofit = builder.build()


    // Service Builder
    fun <T> buildService(serviceType: Class<T>) : T {
        return retrofit.create(serviceType)
    }

}