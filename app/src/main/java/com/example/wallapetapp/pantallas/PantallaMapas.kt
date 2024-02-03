package com.example.wallapetapp.pantallas

import android.location.Address
import android.location.Geocoder
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun Maps(/*codPostal: String*/){
    val codPostal="43700"
    val (latitude, longitude)  = coordinadasDeCodPostal(codPostal)

    val lugar = LatLng(latitude, longitude)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(lugar, 10f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = lugar),
            title = "Mascota",
            snippet = "Población donde se encuentra la mascota"
        )
    }
}
@Composable
fun coord(/*codPostal:String*/){
   val codPostal="43700"
    val (latitude, longitude)  = coordinadasDeCodPostal(codPostal)


    val latitudeDouble: Double
    val longitudeDouble: Double
    if(latitude!=null){
        latitudeDouble = latitude*1
    }else{
        latitudeDouble = 0.0
    }
    if(longitude!=null){
        longitudeDouble = longitude*1
    }else{
        longitudeDouble = 0.0
    }
    Column {
        Text(text = "\n\nLa latitud es $latitude y la longitud es $longitude")
        Text(text = "\n\nLa latitud es $latitudeDouble y la longitud es $longitudeDouble")
    }


}

@Suppress("DEPRECATION")
@Composable
fun coordinadasDeCodPostal(codPostal: String): Pair<Double, Double> {

    val context = LocalContext.current
    val geocoder = Geocoder(context)
    val direcciones = geocoder.getFromLocationName(codPostal, 1,)


    val direccion = direcciones?.get(0)
    val latitud = direccion?.latitude
    val longitud = direccion?.longitude

    val latitudeDouble: Double
    val longitudeDouble: Double
    if(latitud!=null){
        latitudeDouble = latitud*1
    }else{
        latitudeDouble = 0.0
    }
    if(longitud!=null){
        longitudeDouble = longitud*1
    }else{
        longitudeDouble = 0.0
    }

    return latitudeDouble to longitudeDouble
}