package com.pedro.portalberita.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pedro.portalberita.Model.dataModelSport
import com.pedro.portalberita.R
import com.squareup.picasso.Picasso

class AdapterSport (private val list : ArrayList<dataModelSport>) : RecyclerView.Adapter<AdapterSport.SportViewHolder>(){

    inner class SportViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bind(dataModelSport: dataModelSport){
            with(itemView){


                val judul : TextView = findViewById(R.id.judul)
                val tanggal : TextView = findViewById(R.id.tanggal)
                val deskripsi : TextView = findViewById(R.id.deskripsi)
                val image : ImageView = findViewById(R.id.thumb)

                judul.text = "${dataModelSport.title}"
                deskripsi.text = "${dataModelSport.description}"
                tanggal.text = "${dataModelSport.publishedAt}"

                Picasso.get()
                    .load(dataModelSport.urlToImage)
                    .resize(650, 366)
                    .centerCrop()
                    .into(image)

            }
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportViewHolder {

        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.data_tech , parent , false)

        return SportViewHolder(view)
    }

    override fun onBindViewHolder(holder: SportViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}