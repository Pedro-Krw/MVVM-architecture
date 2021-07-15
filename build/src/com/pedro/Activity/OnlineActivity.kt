package com.pedro.portalberita.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedro.portalberita.Adapter.AdapterOnline
import com.pedro.portalberita.Adapter.AdapterTech
import com.pedro.portalberita.Model.ModelOnline
import com.pedro.portalberita.Model.ModelTech
import com.pedro.portalberita.Model.dataModelOnline
import com.pedro.portalberita.Model.dataModelUtama
import com.pedro.portalberita.Network.ApiService
import com.pedro.portalberita.R
import com.pedro.portalberita.databinding.ActivityOnlineBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OnlineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnlineBinding
    private val list  = ArrayList<dataModelOnline>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnlineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
        seOnClick()
        getDataOnline()
    }


    private fun seOnClick(){

        binding.backOnline.setOnClickListener {
            Intent(this@OnlineActivity , MainActivity::class.java).also {
                startActivity(it)
            }
        }

    }


    private fun getDataOnline() {
        binding.recycleViewOnline.setHasFixedSize(true)
        binding.recycleViewOnline.layoutManager = LinearLayoutManager(this)


        ApiService.instance.getDataOnline()
            .enqueue(object : Callback<ModelOnline> {
                override fun onResponse(call: Call<ModelOnline>, response: Response<ModelOnline>) {

                    val listtech = response.body()?.articles
                    listtech?.let { list.addAll(it) }

                    val adapter = AdapterOnline(list)
                    binding.recycleViewOnline.adapter = adapter

                }

                override fun onFailure(call: Call<ModelOnline>, t: Throwable) {

                }

            })
    }


    }