package com.pedro.portalberita.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedro.portalberita.Adapter.AdapterCnbc
import com.pedro.portalberita.Model.ModelCnbc
import com.pedro.portalberita.Model.dataBerita
import com.pedro.portalberita.Network.ApiService
import com.pedro.portalberita.R
import com.pedro.portalberita.databinding.ActivityMainBinding
import com.pedro.portalberita.databinding.ActivityTerkini2Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TerkiniActivity2 : AppCompatActivity() {

    lateinit var binding : ActivityTerkini2Binding
    private val list  = ArrayList<dataBerita>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTerkini2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        seOnclik()
    }


    override fun onStart() {
        super.onStart()
        supportActionBar!!.hide()
        getDataFromApi()
    }

    private fun getDataFromApi(){
        binding.recycleViewCnbc.setHasFixedSize(true)
        binding.recycleViewCnbc.layoutManager = LinearLayoutManager(this)

        ApiService.instance.getDataCnbc()
            .enqueue(object : Callback<ModelCnbc> {
                override fun onResponse(call: Call<ModelCnbc>, response: Response<ModelCnbc>) {




                    val listView = response.body()?.articles

                    listView?.let { list.addAll(it) }

                    val adapter = AdapterCnbc(list)

                    binding.recycleViewCnbc.adapter = adapter




                }

                override fun onFailure(call: Call<ModelCnbc>, t: Throwable) {

                }

            })



    }



    private fun seOnclik(){

        binding.back.setOnClickListener {

            Intent(this@TerkiniActivity2 , MainActivity::class.java).also {
                startActivity(it)
            }

        }


    }


}