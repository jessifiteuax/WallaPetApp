package com.example.wallapetapp.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class imagePathViewModel:ViewModel() {
    private val _imagePath = MutableLiveData<String>()
    val imagePath: LiveData<String>
        get() = _imagePath

    fun setImagePath(path: String) {
        _imagePath.value = path
    }

}