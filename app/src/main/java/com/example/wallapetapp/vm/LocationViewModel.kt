package com.example.wallapetapp.vm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LocationViewModel: ViewModel() {
    private val _longitude = MutableStateFlow(0.0)
    val longitude: StateFlow<Double> = _longitude

    private val _latitude = MutableStateFlow(0.0)
    val latitude: StateFlow<Double> = _latitude
    fun updateLoc(lat: Double, long: Double) {
        _latitude.value = lat
        _longitude.value = long
    }
}