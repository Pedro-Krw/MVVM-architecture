package com.pedro.portalberita.Network

import com.pedro.portalberita.Model.*
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("top-headlines?country=id&apiKey=")
    fun getDataCnbc() : Call<ModelCnbc>

    @GET("top-headlines?country=id&category=science&apiKey=")
    fun getDataUtama() :Call<ModelUtama>

    @GET("top-headlines?country=id&category=entertainment&apiKey=")
    fun gerDataTop() : Call<ModelTop>

    @GET("top-headlines?country=id&category=technology&apiKey=")
    fun getDataTech() : Call<ModelTech>

    @GET("top-headlines?country=id&category=health&apiKey=")
    fun ngetDataHealth() : Call<ModelHealth>

    @GET("top-headlines?country=id&category=business&apiKey=")
    fun getDataOnline() : Call<ModelOnline>

    @GET("top-headlines?country=id&category=sports&apiKey=")
    fun getDataSport() : Call<ModelSport>

}