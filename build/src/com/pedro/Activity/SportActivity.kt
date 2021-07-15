package com.pedro.portalberita.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedro.portalberita.Adapter.AdapterSport
import com.pedro.portalberita.Adapter.AdapterTech
import com.pedro.portalberita.Model.ModelSport
import com.pedro.portalberita.Model.ModelTech
import com.pedro.portalberita.Model.dataModelSport
import com.pedro.portalberita.Model.dataModelTech
import com.pedro.portalberita.Network.ApiService
import com.pedro.portalberita.R
import com.pedro.portalberita.databinding.ActivitySportBinding
import com.pedro.portalberita.databinding.ActivityTechBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SportActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySportBinding
    private val list = ArrayList<dataModelSport>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySportBinding.inflate(layoutInflater)
        setContentView(binding.root)
        seOnClick()
        getDataTech()
        supportActionBar!!.hide()
    }


    private fun seOnClick(){

        binding.backsport.setOnClickListener {
            Intent(this@SportActivity , MainActivity::class.java).also {
                startActivity(it)
            }
        }


    }


    private fun getDataTech(){
        binding.recycleViewSport.setHasFixedSize(true)
        binding.recycleViewSport.layoutManager = LinearLayoutManager(this)


        ApiService.instance.getDataSport()
            .enqueue(object : Callback<ModelSport> {
                override fun onResponse(call: Call<ModelSport>, response: Response<ModelSport>) {

                    val listtech = response.body()?.articles
                    listtech?.let { list.addAll(it) }

                    val adapter = AdapterSport(list)
                    binding.recycleViewSport.adapter = adapter

                }

                override fun onFailure(call: Call<ModelSport>, t: Throwable) {

                }

            })



    }


}