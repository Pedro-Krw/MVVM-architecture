package com.pedro.portalberita.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedro.portalberita.Adapter.AdapterTech
import com.pedro.portalberita.Model.ModelTech
import com.pedro.portalberita.Model.dataModelTech
import com.pedro.portalberita.Network.ApiService
import com.pedro.portalberita.R
import com.pedro.portalberita.databinding.ActivityTechBinding
import com.pedro.portalberita.databinding.ActivityTopBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TechActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTechBinding
    private val list = ArrayList<dataModelTech>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTechBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        seOnClick()
        getDataTech()
        supportActionBar!!.hide()
    }



    private fun seOnClick(){

        binding.backtech.setOnClickListener {
            Intent(this@TechActivity , MainActivity::class.java).also {
                startActivity(it)
            }
        }


    }


    private fun getDataTech(){
        binding.recycleViewTech.setHasFixedSize(true)
        binding.recycleViewTech.layoutManager = LinearLayoutManager(this)


        ApiService.instance.getDataTech()
            .enqueue(object : Callback<ModelTech>{
                override fun onResponse(call: Call<ModelTech>, response: Response<ModelTech>) {

                    val listtech = response.body()?.articles
                    listtech?.let { list.addAll(it) }

                    val adapter = AdapterTech(list)
                    binding.recycleViewTech.adapter = adapter

                }

                override fun onFailure(call: Call<ModelTech>, t: Throwable) {

                }

            })



    }



}