package com.pedro.portalberita.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedro.portalberita.Adapter.AdapterHealth
import com.pedro.portalberita.Adapter.AdapterTop
import com.pedro.portalberita.Model.ModelHealth
import com.pedro.portalberita.Model.ModelTop
import com.pedro.portalberita.Model.dataModelhealth
import com.pedro.portalberita.Network.ApiService
import com.pedro.portalberita.R
import com.pedro.portalberita.databinding.ActivityHeathBinding
import com.pedro.portalberita.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeathActivity : AppCompatActivity() {

    lateinit var binding : ActivityHeathBinding
    private val list = ArrayList<dataModelhealth>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeathBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
    }


    override fun onStart() {
        super.onStart()

        setOnClick()
        getDataHealth()
    }


    private fun setOnClick(){

        binding.backhealth.setOnClickListener {
            Intent(this@HeathActivity , MainActivity::class.java).also {
                startActivity(it)
            }


        }

    }


    private fun getDataHealth(){
        binding.recycleViewHealth.setHasFixedSize(true)
        binding.recycleViewHealth.layoutManager = LinearLayoutManager(this)


        ApiService.instance.ngetDataHealth()
            .enqueue(object : Callback<ModelHealth> {
                override fun onResponse(call: Call<ModelHealth>, response: Response<ModelHealth>) {

                    val listhealt = response.body()?.articles
                    listhealt?.let { list.addAll(it) }

                    val adapter = AdapterHealth(list)
                    binding.recycleViewHealth.adapter = adapter

                }

                override fun onFailure(call: Call<ModelHealth>, t: Throwable) {

                }

            })


    }

}