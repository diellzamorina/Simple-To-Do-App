package com.example.todoshomework.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoshomework.R
import com.example.todoshomework.adapter.UserAdapter
import com.example.todoshomework.databinding.FragmentUserBinding
import com.example.todoshomework.helpers.SingletonHelpersObject.provideRetrofitInstance
import com.example.todoshomework.model.Data
import com.example.todoshomework.model.MyData
import com.example.todoshomework.model.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserAdapter
    private var myDataList = mutableListOf<MyData>()


    private lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = UserAdapter(myDataList)
        recyclerView.adapter = adapter
        createDataList()

    }

    private fun createDataList() {
        myDataList.add(MyData("https://reqres.in/img/faces/1-image.jpg", "Do something nice for someone I care about"))
        myDataList.add(MyData("https://reqres.in/img/faces/2-image.jpg", "Memorize the fifty states and their capitals"))
        myDataList.add(MyData("https://reqres.in/img/faces/3-image.jpg", "Watch a classic movie"))
        myDataList.add(MyData("https://reqres.in/img/faces/4-image.jpg", "Have a photo session with some friends"))
        myDataList.add(MyData("https://reqres.in/img/faces/5-image.jpg", "Take a class at local community center that interests you"))
        myDataList.add(MyData("https://reqres.in/img/faces/6-image.jpg", "Improve touch typing"))
        myDataList.add(MyData("https://reqres.in/img/faces/1-image.jpg", "Make own LEGO creation"))
        myDataList.add(MyData("https://reqres.in/img/faces/3-image.jpg", "Take cat on a walk"))
        myDataList.add(MyData("https://reqres.in/img/faces/2-image.jpg", "Plan a trip to another country"))
        myDataList.add(MyData("https://reqres.in/img/faces/4-image.jpg", "Text a friend I haven't talked to in a long time"))
    }
}















