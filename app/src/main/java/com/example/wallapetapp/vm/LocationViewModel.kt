package com.example.wallapetapp.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LocationViewModel : ViewModel() {
    private val _latitude = MutableStateFlow(0.0)
    private val _longitude = MutableStateFlow(0.0)

    val latitude = _latitude.asStateFlow()
    val longitude = _longitude.asStateFlow()

    fun setLocation(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            _latitude.emit(latitude)
            _longitude.emit(longitude)
        }
    }
}

/*class LocationViewModel : ViewModel() {

    private val _latitude = MutableLiveData<Double>()
    val latitude: LiveData<Double>
        get() = _latitude

    fun setLatitude(lat: Double) {
        _latitude.value = lat
    }

    private val _longitude = MutableLiveData<Double>()
    val longitude: LiveData<Double>
        get() = _longitude

    fun setLongitude(long: Double) {
        _longitude.value = long
    }
}
*/


/*class LocationViewModel: ViewModel() {
    private val _longitude = MutableStateFlow(0.0)
    val longitude: StateFlow<Double> = _longitude

    private val _latitude = MutableStateFlow(0.0)
    val latitude: StateFlow<Double> = _latitude
    fun updateLoc(lat: Double, long: Double) {
        _latitude.value = lat
        _longitude.value = long
    }
}*/