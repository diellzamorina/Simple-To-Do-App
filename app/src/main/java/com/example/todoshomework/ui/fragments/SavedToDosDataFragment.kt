package com.example.todoshomework.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoshomework.R
import com.example.todoshomework.databinding.FragmentSavedToDosDataBinding
import com.example.todoshomework.helpers.SingletonHelpersObject.getStringFromSharedPrefs
import com.google.android.material.snackbar.Snackbar


class SavedToDosDataFragment : Fragment() {

private lateinit var binding: FragmentSavedToDosDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val value = arguments?.getString("key")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSavedToDosDataBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getValuesFromSharedPreferences()
    }

    private fun getValuesFromSharedPreferences(){
        binding.btnSharedPrefs.setOnClickListener{
            val sharedPrefs = getStringFromSharedPrefs(requireContext(),"toDo")
            if (sharedPrefs != null) {
                if (sharedPrefs.isNotEmpty()){
                    binding.tvText.text= sharedPrefs.toString()
                }else{
                    Snackbar.make(requireView(),"Nuk ka asnje todo ne Shared Preferences!",Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }


}