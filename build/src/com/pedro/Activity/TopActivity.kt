package com.pedro.portalberita.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedro.portalberita.Adapter.AdapterTop
import com.pedro.portalberita.Model.ModelTop
import com.pedro.portalberita.Model.dataModelTop
import com.pedro.portalberita.Network.ApiService
import com.pedro.portalberita.R
import com.pedro.portalberita.databinding.ActivityTopBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopActivity : AppCompatActivity() {

    lateinit var binding: ActivityTopBinding
    private val list = ArrayList<dataModelTop>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
    }


    override fun onStart() {
        super.onStart()
        
        setOnClick()
        getDataTop()
    }


    private fun setOnClick(){

        binding.backtop.setOnClickListener {
            Intent(this@TopActivity , MainActivity::class.java).also {
                startActivity(it)
            }


        }
        
    }


    private fun getDataTop(){
        binding.recycleViewTop.setHasFixedSize(true)
        binding.recycleViewTop.layoutManager = LinearLayoutManager(this)
        
        
        ApiService.instance.gerDataTop()
            .enqueue(object : Callback<ModelTop> {
                override fun onResponse(call: Call<ModelTop>, response: Response<ModelTop>) {

                    val listtop = response.body()?.articles
                    listtop?.let { list.addAll(it) }

                    val adapter = AdapterTop(list)
                    binding.recycleViewTop.adapter = adapter

                }

                override fun onFailure(call: Call<ModelTop>, t: Throwable) {

                }

            })
        
        
    }
    
}