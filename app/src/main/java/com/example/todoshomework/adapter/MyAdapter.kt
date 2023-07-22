package com.example.todoshomework.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import com.example.todoshomework.R
import com.example.todoshomework.model.ToDo



class MyAdapter(private val context: Context, private val todoList: List<ToDo>) : BaseAdapter(){

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = todoList.size

    override fun getItem(position : Int)= todoList[position]

    override fun getItemId(position : Int): Long = position.toLong()

    @SuppressLint("MissingInflatedId", "ViewHolder")
        override fun getView(position: Int, p1: View?,p2: ViewGroup?): View {

        val rowView = inflater.inflate(R.layout.list_item,p2,false)

//        val tvId = rowView.findViewById<TextView>(R.id.tvId)
//        val tvUserId = rowView.findViewById<TextView>(R.id.tvUserId)
        val tvToDo= rowView.findViewById<TextView>(R.id.tvToDo)
        val tvCompleted = rowView.findViewById<TextView>(R.id.tvCompleted)

//        tvId.text = todoList[position].id.toString()
//        tvUserId.text = todoList[position].userId.toString()
        tvToDo.text = todoList[position].todo
        tvCompleted.text = todoList[position].completed.toString()

        if(todoList[position].completed == true){
            rowView.setBackgroundColor(Color.rgb(60, 179, 113))
        }
        else rowView.setBackgroundColor(Color.rgb(255, 0, 0))


        return rowView



    }
}

