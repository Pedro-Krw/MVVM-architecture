package com.pedro.portalberita.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pedro.portalberita.Model.dataModelUtama
import com.pedro.portalberita.R
import com.squareup.picasso.Picasso

class AdapterModelUtama (private val list: ArrayList<dataModelUtama>) : RecyclerView.Adapter<AdapterModelUtama.UtamaViewHolder>(){

    inner class UtamaViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bind(dataModelUtama: dataModelUtama){
            with(itemView){

                val image : ImageView = findViewById(R.id.imageUtama)
                val judul : TextView = findViewById(R.id.judulUtama)
                val deskripsi : TextView = findViewById(R.id.deskripsiUtama)
                val tanggal : TextView = findViewById(R.id.tanggalUtama)

                judul.text = "${dataModelUtama.title}"
                deskripsi.text = "${dataModelUtama.description}"
                tanggal.text = "Rilis : ${dataModelUtama.publishedAt}"


                Picasso.get()
                    .load(dataModelUtama.urlToImage)
                    .resize(700 , 370)
                    .centerCrop()
                    .into(image)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UtamaViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.data_utama , parent , false)

        return UtamaViewHolder(view)
    }

    override fun onBindViewHolder(holder: UtamaViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}