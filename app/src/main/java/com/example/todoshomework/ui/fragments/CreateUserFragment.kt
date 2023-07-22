package com.example.todoshomework.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.todoshomework.R
import com.example.todoshomework.api.ServiceAPI
import com.example.todoshomework.model.RequestModel
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CreateUserFragment : Fragment() {
    private lateinit var createUserButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_user2, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        createUserButton = view.findViewById(R.id.btnCreate)
        createUserButton.setOnClickListener{
            val name = view.findViewById<EditText>(R.id.name).text.toString()
            val job = view.findViewById<EditText>(R.id.job).text.toString()
            val user = RequestModel(name,job)


            val retrofit = Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(ServiceAPI::class.java)


            service.createUser(user).enqueue( object : Callback<RequestModel>{

                override fun onResponse(
                    call: Call<RequestModel>,
                    response: Response<RequestModel>
                ) {
                    if (response.isSuccessful) {

                        Snackbar.make(view, "User successfully created!", Snackbar.LENGTH_LONG)
                            .show()
//                    } else {
//                        Snackbar.make(view, "Error: ${response.message()}", Snackbar.LENGTH_LONG).show()
//                    }
                    }
                }

                override fun onFailure(call: Call<RequestModel>, t: Throwable) {
                    Snackbar.make(view, "Error: ${t.message}", Snackbar.LENGTH_LONG).show()
                }
            })
        }
    }
    //...


}