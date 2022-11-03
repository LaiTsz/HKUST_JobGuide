package com.example.hkust_jobguide

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*


class homeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }
    fun initRecyclerView(){
        val eventBackgroundList=mutableListOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8
        )
        val talkList = mutableListOf(
            Event("asdfssdf",eventBackgroundList[0]),
            Event("asdfssdf",eventBackgroundList[1]),
            Event("asdfssdf",eventBackgroundList[2]),
            Event("asdfssdf",eventBackgroundList[3]),
            Event("asdfssdf",eventBackgroundList[4]),
            Event("asdfssdf",eventBackgroundList[5]),
            Event("asdfssdf",eventBackgroundList[6]),
            Event("asdfssdf",eventBackgroundList[7])
        )
        val jobList = mutableListOf(
            Event("sasfasbs",eventBackgroundList[0]),
            Event("sasfasbs",eventBackgroundList[1]),
            Event("sasfasbs",eventBackgroundList[2]),
            Event("sasfasbs",eventBackgroundList[3]),
            Event("sasfasbs",eventBackgroundList[4]),
            Event("sasfasbs",eventBackgroundList[5]),
            Event("sasfasbs",eventBackgroundList[6]),
            Event("sasfasbs",eventBackgroundList[7])
        )
        val rvTalk : RecyclerView? = view?.findViewById(R.id.rvTalk)
        val rvJob : RecyclerView? = view?.findViewById(R.id.rvJob)
        val talkAdapter = EventAdapter(talkList)
        val jobAdapter = EventAdapter(jobList)
        Log.d("homeFragment", "test")
        if (rvTalk != null && rvJob !=null) {
            rvTalk.adapter = talkAdapter
            rvJob.adapter = jobAdapter
        }
        if (rvTalk != null && rvJob !=null) {
            rvTalk.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            rvJob.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
        val btnAddTodo : Button? = view?.findViewById(R.id.btnAddTodo)
        if (btnAddTodo != null) {
            btnAddTodo.setOnClickListener {
                val title = etTodo.text.toString()
                val event = Event(title,eventBackgroundList[0])
                talkList.add(event)
                talkAdapter.notifyItemInserted(talkList.size - 1)
            }
        }
    }
}