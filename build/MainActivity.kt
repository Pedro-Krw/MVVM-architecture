package com.pedro.latihanpicasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedro.latihanpicasso.Adapter.AdapterResep
import com.pedro.latihanpicasso.Model.ModelResep
import com.pedro.latihanpicasso.Model.User
import com.pedro.latihanpicasso.Network.ApiService
import com.pedro.latihanpicasso.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataFromApi()
    }


    private fun getDataFromApi(){
        binding.recycle.setHasFixedSize(true)
        binding.recycle.layoutManager = LinearLayoutManager(this )

        ApiService.instance.getData()
            .enqueue(object : Callback<ModelResep>{
                override fun onResponse(call: Call<ModelResep>, response: Response<ModelResep>) {


                    val responseList = response.body()?.results
                    responseList?.let { list.addAll(it) }
                    val adapter = AdapterResep(list)
                    binding.recycle.adapter = adapter

                }

                override fun onFailure(call: Call<ModelResep>, t: Throwable) {

                }

            })



    }
}