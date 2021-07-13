package com.pedro.latihanpicasso.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {


    val instance by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://masak-apa-tomorisakura.vercel.app/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiEndpoint::class.java)

    }


}