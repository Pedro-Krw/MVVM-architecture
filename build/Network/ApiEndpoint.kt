package com.pedro.latihanpicasso.Network

import com.pedro.latihanpicasso.Model.ModelResep
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("recipes")
    fun getData() : Call<ModelResep>
}