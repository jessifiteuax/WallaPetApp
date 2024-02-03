package com.example.wallapetapp.pantallas

import android.location.Address
import android.location.Geocoder
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.wallapetapp.R
import com.example.wallapetapp.components.iconoBarra
import com.example.wallapetapp.components.textoBarra
import com.example.wallapetapp.navegacion.BarraNav
import com.example.wallapetapp.ui.theme.WallaColTopBar
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maps(navHostController: NavHostController,
         codPostal: String){
    //val codPostal="43700"
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { textoBarra(texto = "¿Dónde está?" )},
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = WallaColTopBar
                ),
                navigationIcon = {
                    iconoBarra(navHostController)
                }
            )
        },
        content = {
                padding ->
            ContenidoMaps(padding, codPostal)
        }
    )
}
@Composable
fun ContenidoMaps(padding:PaddingValues, codPostal: String){

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