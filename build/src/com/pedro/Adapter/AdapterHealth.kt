package com.pedro.portalberita.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pedro.portalberita.Model.dataModelhealth
import com.pedro.portalberita.R
import com.squareup.picasso.Picasso

class AdapterHealth(private val list : ArrayList<dataModelhealth>) : RecyclerView.Adapter<AdapterHealth.HealthViewHolder>() {

    inner class HealthViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bind(dataModelhealth: dataModelhealth){
            with(itemView){


                val judul : TextView = findViewById(R.id.judul)
                val tanggal : TextView = findViewById(R.id.tanggal)
                val deskripsi : TextView = findViewById(R.id.deskripsi)
                val image : ImageView = findViewById(R.id.thumb)

                judul.text = "${dataModelhealth.title}"
                deskripsi.text = "${dataModelhealth.description}"
                tanggal.text = "${dataModelhealth.publishedAt}"

                Picasso.get()
                    .load(dataModelhealth.urlToImage)
                    .resize(650, 366)
                    .centerCrop()
                    .into(image)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthViewHolder {

        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.data_tech , parent , false)

        return HealthViewHolder(view)
    }

    override fun onBindViewHolder(holder: HealthViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}



