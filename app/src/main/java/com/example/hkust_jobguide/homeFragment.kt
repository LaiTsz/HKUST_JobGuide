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
        val todoList = mutableListOf(
            Todo("asdfssdf", false),
            Todo("asdfssdf", false),
            Todo("asdfssdf", false),
            Todo("asdfssdf", false),
            Todo("asdfssdf", false),
            Todo("asdfssdf", false),
            Todo("asdfssdf", false),
            Todo("asdfssdf", false)
        )
        val rvTodos : RecyclerView? = view?.findViewById(R.id.rvTodos)
        val adapter = TodoAdapter(todoList)
        Log.d("homeFragment", "test")
        if (rvTodos != null) {
            rvTodos.adapter = adapter
        }
        if (rvTodos != null) {
            rvTodos.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
        val btnAddTodo : Button? = view?.findViewById(R.id.btnAddTodo)
        if (btnAddTodo != null) {
            btnAddTodo.setOnClickListener {
                val title = etTodo.text.toString()
                val todo = Todo(title, false)
                todoList.add(todo)
                adapter.notifyItemInserted(todoList.size - 1)
            }
        }
    }
}