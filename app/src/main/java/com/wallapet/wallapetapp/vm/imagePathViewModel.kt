package com.wallapet.wallapetapp.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImagePathViewModel:ViewModel() {
    private val _imagePath = MutableLiveData<String>()
    val imagePath: LiveData<String>
        get() = _imagePath

    fun setImagePath(path: String) {
        _imagePath.value = path
    }

}