package com.administrator.firebase

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.card_item.view.*

class viewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){

    var title = itemView.h
    var message = itemView.m
    var layout = itemView.l
}