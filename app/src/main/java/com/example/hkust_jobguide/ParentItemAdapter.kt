package com.example.hkust_jobguide

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ParentItemAdapter (
        private val itemList : List<ParentItem>): RecyclerView.Adapter<ParentItemAdapter.ParentViewHolder>(){
        private val viewPool : RecyclerView.RecycledViewPool=RecyclerView.RecycledViewPool()

    class ParentViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView) {
            var ParentItemTitle: TextView=itemView.findViewById(R.id.parent_item_title)
            var childRecyclerView: RecyclerView=itemView.findViewById(R.id.child_recyclerview)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
            val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.parent_item,parent,false)
            return ParentViewHolder(adapterLayout)
        }

        override fun onBindViewHolder(parentViewHolder: ParentViewHolder, position: Int) {
            val parentItem :ParentItem = itemList[position]
            parentViewHolder.ParentItemTitle.text = parentItem.ParentItemTitle
            val layoutManager= LinearLayoutManager(
                parentViewHolder.childRecyclerView.context,LinearLayoutManager.HORIZONTAL,false)
            layoutManager.initialPrefetchItemCount = parentItem.ChildItemList.size
            val childItemAdapter = ChildItemAdapter(
                parentItem
                    .ChildItemList
            )
            parentViewHolder.childRecyclerView.layoutManager = layoutManager
            parentViewHolder.childRecyclerView.adapter = childItemAdapter
            parentViewHolder.childRecyclerView.setRecycledViewPool(viewPool)
        }

        override fun getItemCount(): Int {
            return itemList.size
        }

    }