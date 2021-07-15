package com.pedro.portalberita.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedro.portalberita.Adapter.AdapterModelUtama
import com.pedro.portalberita.Model.ModelUtama
import com.pedro.portalberita.Model.dataModelUtama
import com.pedro.portalberita.Network.ApiService
import com.pedro.portalberita.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {



    lateinit var binding : ActivityMainBinding
    private val list  = ArrayList<dataModelUtama>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()
        setOnClick()
        getDataUtama()

        supportActionBar!!.hide()

    }


    private fun getDataUtama(){
        binding.recycle.setHasFixedSize(true)
        binding.recycle.layoutManager = LinearLayoutManager(this)

        ApiService.instance.getDataUtama()
            .enqueue(object : Callback<ModelUtama> {
                override fun onResponse(call: Call<ModelUtama>, response: Response<ModelUtama>) {

                    val listPost = response.body()?.articles
                    listPost?.let { list.addAll(it) }

                    val adapter = AdapterModelUtama(list)

                    binding.recycle.adapter = adapter




                }

                override fun onFailure(call: Call<ModelUtama>, t: Throwable) {

                }

            })



    }



    private fun setOnClick(){

        binding.viewA.setOnClickListener{
            Intent(this@MainActivity , TerkiniActivity2::class.java).also {
                startActivity(it)
            }
        }

        binding.viewB.setOnClickListener{
            Intent(this@MainActivity , TopActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.viewC.setOnClickListener{
            Intent(this@MainActivity , TechActivity::class.java).also {
                startActivity(it)
            }
        }


        binding.viewD.setOnClickListener{
            Intent(this@MainActivity , HeathActivity::class.java).also {
                startActivity(it)
            }
        }


        binding.viewE.setOnClickListener{
            Intent(this@MainActivity , OnlineActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.viewF.setOnClickListener{
            Intent(this@MainActivity , SportActivity::class.java).also {
                startActivity(it)
            }
        }

    }

    }


