package com.pedro.portalberita.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pedro.portalberita.Model.dataModelTech
import com.pedro.portalberita.R
import com.squareup.picasso.Picasso

class AdapterTech (private val list : ArrayList<dataModelTech>) : RecyclerView.Adapter<AdapterTech.TechViewHolder>() {

    inner class TechViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bind(dataModelTech: dataModelTech){
            with(itemView){


                val judul : TextView = findViewById(R.id.judul)
                val tanggal : TextView = findViewById(R.id.tanggal)
                val deskripsi : TextView = findViewById(R.id.deskripsi)
                val image : ImageView = findViewById(R.id.thumb)

                judul.text = "${dataModelTech.title}"
                deskripsi.text = "${dataModelTech.description}"
                tanggal.text = "${dataModelTech.publishedAt}"

                Picasso.get()
                    .load(dataModelTech.urlToImage)
                    .resize(650, 366)
                    .centerCrop()
                    .into(image)

            }
        }

    }

    class OnlineViewHolder {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TechViewHolder {

        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.data_tech , parent , false)

        return TechViewHolder(view)
    }

    override fun onBindViewHolder(holder: TechViewHolder, position: Int) {
       holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}