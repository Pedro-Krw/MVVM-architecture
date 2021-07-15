package com.pedro.portalberita.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pedro.portalberita.Model.dataModelOnline
import com.pedro.portalberita.R
import com.squareup.picasso.Picasso

class AdapterOnline (private val list : ArrayList<dataModelOnline>) : RecyclerView.Adapter<AdapterOnline.OnlineViewHolder>(){

    inner class OnlineViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bind(dataModelOnline: dataModelOnline){
            with(itemView){


                val judul : TextView = findViewById(R.id.judul)
                val tanggal : TextView = findViewById(R.id.tanggal)
                val deskripsi : TextView = findViewById(R.id.deskripsi)
                val image : ImageView = findViewById(R.id.thumb)

                judul.text = "${dataModelOnline.title}"
                deskripsi.text = "${dataModelOnline.description}"
                tanggal.text = "${dataModelOnline.publishedAt}"

                Picasso.get()
                    .load(dataModelOnline.urlToImage)
                    .resize(650, 366)
                    .centerCrop()
                    .into(image)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnlineViewHolder {

        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.data_tech , parent , false)

        return OnlineViewHolder(view)
    }

    override fun onBindViewHolder(holder: OnlineViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


}