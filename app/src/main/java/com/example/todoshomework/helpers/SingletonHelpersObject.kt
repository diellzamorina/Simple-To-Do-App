package com.example.todoshomework.helpers

import android.content.Context
import android.content.SharedPreferences
import com.example.todoshomework.api.ServiceAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SingletonHelpersObject {
    private const val BASE_URL = "https://dummyjson.com/"
    private const val SHARED_PREFS_NAME = "app_shared_preferences"

    fun provideRetrofitInstance(): ServiceAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://dummyjson.com/")
            .build()
            .create(ServiceAPI::class.java)
    }

    private fun provideSharedPrefsInstance(context : Context) : SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFS_NAME,Context.MODE_PRIVATE)
    }

    fun putStringOnSharedPrefs(context : Context , key : String , value : String) {
        provideSharedPrefsInstance(context).edit().apply {
            putString(key,value)
            apply()
        }
    }

    fun getStringFromSharedPrefs(context: Context , key : String) : String? {
        return provideSharedPrefsInstance(context).getString(key,"")
    }
}