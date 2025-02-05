package com.ekyc.extendedfabbutton

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val list: MutableList<Email>): RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view:View) :RecyclerView.ViewHolder(view) {
val heading:TextView=view.findViewById(R.id.heading);
val message:TextView=view.findViewById(R.id.message);
val name:TextView=view.findViewById(R.id.hname);
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.single_design,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
holder.name.text=list.get(position).title.substring(0,1)
        holder.heading.text=list.get(position).title
        holder.message.text=list.get(position).message
    }
}