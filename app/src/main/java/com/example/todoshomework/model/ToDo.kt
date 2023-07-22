package com.example.todoshomework.model


data class ToDo(
    val userId: Int,
    val id: Int,
    val todo: String?,
    val completed: Boolean
)
