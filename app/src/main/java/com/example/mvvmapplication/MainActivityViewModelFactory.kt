package com.example.mvvmapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


//used for instantiating the viewModel which prevents the app from crashing
//whenever the activity is not found

class MainActivityViewModelFactory(): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel() as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }

}