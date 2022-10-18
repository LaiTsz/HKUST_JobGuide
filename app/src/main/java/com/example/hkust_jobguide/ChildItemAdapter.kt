package com.example.hkust_jobguide

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hkust_jobguide.R

class ChildItemAdapter(
    private val ChildItemList :List<ChildItem>,
): RecyclerView.Adapter<ChildItemAdapter.ChildViewHolder>(){
    class ChildViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val childItemTitle: TextView = view.findViewById(R.id.child_item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.child_item,parent,false)
        return  ChildViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(childViewHolder: ChildViewHolder, position: Int) {
        val childItem :ChildItem = ChildItemList[position]
        childViewHolder.childItemTitle.text = childItem.ChildItemTitle
    }

    override fun getItemCount(): Int {
        return ChildItemList.size
    }
}

