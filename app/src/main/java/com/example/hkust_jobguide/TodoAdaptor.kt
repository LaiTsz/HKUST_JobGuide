package com.example.hkust_jobguide
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventAdapter (
    var events: List<Event>
):RecyclerView.Adapter<EventAdapter.TodoViewHolder>(){
    inner class TodoViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val title:TextView = itemView.findViewById(R.id.info_text)
        val eventImage: ImageView = itemView.findViewById(R.id.event_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val item = events[position]
        holder.eventImage.setImageResource(item.image)
        holder.title.text = item.title
    }

    override fun getItemCount(): Int {
        return events.size
    }
}