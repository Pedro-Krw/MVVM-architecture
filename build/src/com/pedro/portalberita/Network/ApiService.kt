package com.pedro.portalberita.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {


    val instance by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiEndpoint::class.java)



    }

}