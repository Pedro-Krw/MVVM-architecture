package com.pedro.latihanpicasso.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pedro.latihanpicasso.Model.ModelResep
import com.pedro.latihanpicasso.Model.User
import com.pedro.latihanpicasso.R
import com.squareup.picasso.Picasso

class AdapterResep (private val list: ArrayList<User>) : RecyclerView.Adapter<AdapterResep.ResepViewHolder>() {


    inner class ResepViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){


        fun bind(user: User){

            with(itemView){

                val text : ImageView = findViewById(R.id.imageSatu)

                Picasso.get()
                    .load(user.thumb)
                    .resize(400, 240)
                    .centerCrop()
                    .into(text)



            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResepViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.resep_makanan , parent ,false)

        return ResepViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResepViewHolder, position: Int) {
       holder.bind(list[position])





    }

    override fun getItemCount(): Int = list.size




}