package com.pedro.portalberita.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pedro.portalberita.Model.dataModelTop
import com.pedro.portalberita.R
import com.squareup.picasso.Picasso

class AdapterTop (private val list: ArrayList<dataModelTop>) : RecyclerView.Adapter<AdapterTop.TopViewHolder>(){

    inner class TopViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bind(dataModelTop: dataModelTop){
            with(itemView){

                val judul : TextView = findViewById(R.id.judul)
                val tanggal : TextView = findViewById(R.id.tanggal)
                val deskripsi : TextView = findViewById(R.id.deskripsi)
                val image : ImageView = findViewById(R.id.thumb)

                judul.text = "${dataModelTop.title}"
                deskripsi.text = "${dataModelTop.description}"
                tanggal.text = "${dataModelTop.publishedAt}"

                Picasso.get()
                    .load(dataModelTop.urlToImage)
                    .resize(650, 366)
                    .centerCrop()
                    .into(image)


            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.data_top , parent , false)

        return TopViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}