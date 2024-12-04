package com.ogee.futboltakimi

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class MyAdaptor(var oyunculistesi :List<oyuncu>)
    :RecyclerView.Adapter<MyAdaptor.myViewHolder>() {

        class myViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){
            var textView = itemView.findViewById<TextView>(R.id.rcycle_row_text)
            var imageView = itemView.findViewById<ImageView>(R.id.rcycle_row_image)

        }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.textView.text = oyunculistesi[position].name
        holder.imageView.setImageResource(oyunculistesi[position].image)
        holder.itemView.setOnClickListener{
            var intent = Intent(holder.itemView.context,detay::class.java)

            intent.putExtra("image",oyunculistesi[position].image)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.rcycle_row,parent,false)
        return  myViewHolder(view)
    }

    override fun getItemCount(): Int {
        return oyunculistesi.size

    }


}