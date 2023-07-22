package com.example.todoshomework.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.todoshomework.R
import com.example.todoshomework.adapter.MyAdapter
import com.example.todoshomework.api.ServiceAPI
import com.example.todoshomework.databinding.FragmentToDoBinding
import com.example.todoshomework.helpers.SingletonHelpersObject.provideRetrofitInstance
import com.example.todoshomework.helpers.SingletonHelpersObject.putStringOnSharedPrefs
//import com.example.todoshomework.helpers.SingletonHelpersObject.BASE_URL
import com.example.todoshomework.model.ToDo
import com.example.todoshomework.model.ToDoJSON
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ToDoFragment : Fragment() {
    private lateinit var binding: FragmentToDoBinding
    private lateinit var listOfToDos1: List<ToDoJSON>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentToDoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        makeApiCalls()
        navigateToSecondFragment()
    }


    private fun makeApiCalls() {
        val getAllToDos = provideRetrofitInstance().getAllToDos()
        binding.progressBar.visibility = View.VISIBLE
        getAllToDos.enqueue(object : Callback<ToDoJSON> {

            override fun onResponse(
                call: Call<ToDoJSON>,
                response: Response<ToDoJSON>
            ) {
                binding.progressBar.visibility = View.GONE
                Log.d("TAG", "onResponse: ${response.body()} call: $call")
                val listOfToDos = response.body()!!

//                adapter = listOfToDos?.let { MyAdapter(requireContext(), it.todos) }!!
//                binding.lvList.adapter = adapter

                val adapter = listOfToDos?.let { MyAdapter(requireContext(), it.todos) }!!
                binding.lvList.adapter = adapter




                binding.lvList.setOnItemClickListener { adapterView, view, i, l ->

                    val toDo = listOfToDos?.todos?.get(i)
                    if (toDo != null) {
                        if (!toDo.completed) {
                            val snackbar = Snackbar.make(
                                view,
                                "To Do nuk mund te ruhet sepse ka vleren false!",
                                Snackbar.LENGTH_LONG
                            )
                            snackbar.show()
                        } else {
                            toDo.todo?.let { putStringOnSharedPrefs(requireContext(), "toDo", it) }
                            val snackbar = Snackbar.make(
                                view,
                                "To Do u ruajt me sukses!",
                                Snackbar.LENGTH_LONG
                            )
                            snackbar.show()
                        }
                    }
                }

            }

            override fun onFailure(call: Call<ToDoJSON>, t: Throwable) {
                binding.progressBar.visibility = View.GONE
                Log.d("Tag", "onFailure: ${t.message}")
            }
        })
    }



    fun navigateToSecondFragment() {
        binding.button.setOnClickListener {
            val action = ToDoFragmentDirections.actionNavToDoToNavSavedToDos()
            findNavController().navigate(action)
        }
    }




}
