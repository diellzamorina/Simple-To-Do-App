package com.example.todoshomework.api

import com.example.todoshomework.model.RequestModel
import com.example.todoshomework.model.ToDoJSON
import com.example.todoshomework.model.Users

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceAPI {
    @GET("todos")
    fun getAllToDos() : Call<ToDoJSON>


    @POST("users")
    fun createUser(@Body user: RequestModel): Call<RequestModel>

}