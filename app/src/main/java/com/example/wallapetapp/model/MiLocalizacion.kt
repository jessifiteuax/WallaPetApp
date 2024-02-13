package com.example.wallapetapp.model

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices

@Suppress("DEPRECATION")
@Composable
fun getCurrentLocationNO() {
   //fun that get the current location and save them in the variables latitude and longitude
    val context = LocalContext.current
    var latitude = 0.1
    var longitude = 0.0
    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        != PackageManager.PERMISSION_GRANTED
    ) {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: android.location.Location? ->
                latitude = location?.latitude!!
                longitude = location?.longitude!!
            }
    }
    Column {
        Text("Latitud: $latitude")
        Text("Longitud: $longitude")
    }
    //return the latitude and longitude
    //return Pair(latitude, longitude)

}


//@Composable
private fun isLocationEnabled(context: Context): Boolean {
    val locationManager: LocationManager =
        getSystemService(context, LocationManager::class.java) as LocationManager
    return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
        LocationManager.NETWORK_PROVIDER
    )
}