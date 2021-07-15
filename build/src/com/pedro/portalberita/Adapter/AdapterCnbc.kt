package com.pedro.portalberita.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pedro.portalberita.Model.dataBerita
import com.pedro.portalberita.R
import com.squareup.picasso.Picasso

class AdapterCnbc (private val list : ArrayList<dataBerita>) : RecyclerView.Adapter<AdapterCnbc.AdapterViewHolder>(){
   inner class AdapterViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

       fun bind(dataBerita: dataBerita){

           with(itemView){

               val judul : TextView = findViewById(R.id.judul)
               val tanggal : TextView = findViewById(R.id.tanggal)
               val deskripsi : TextView = findViewById(R.id.deskripsi)
               val image : ImageView = findViewById(R.id.thumb)

               judul.text = "${dataBerita.title}"
               deskripsi.text = "${dataBerita.description}"
               tanggal.text = "${dataBerita.publishedAt}"

               Picasso.get()
                   .load(dataBerita.urlToImage)
                   .resize(650, 366)
                   .centerCrop()
                   .into(image)


           }
       }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.data_cnbc, parent , false)

        return AdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}