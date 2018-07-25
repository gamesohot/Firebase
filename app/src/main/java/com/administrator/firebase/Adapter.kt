package com.administrator.firebase

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class Adapter (var  data: ArrayList<Data>) : RecyclerView.Adapter<viewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var view  =LayoutInflater.from(parent.context).inflate(R.layout.card_item,parent,false)
        return  viewHolder(view)

    }


    override fun getItemCount(): Int {
    return  data.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
    val  slot = data[position]
        holder.title.text = slot.title.toString()
        holder.message.text = slot.message
    }

}