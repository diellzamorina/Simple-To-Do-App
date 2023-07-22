package com.example.todoshomework.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoshomework.R
import com.example.todoshomework.model.MyData


class MyViewModel : ViewModel() {
    val myDataList = MutableLiveData<List<MyData>>()
}