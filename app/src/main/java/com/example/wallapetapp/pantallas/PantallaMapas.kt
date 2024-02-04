package com.example.wallapetapp.pantallas

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.location.LocationManagerCompat.isLocationEnabled
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.wallapetapp.components.iconoBarra
import com.example.wallapetapp.components.textoBarra
import com.example.wallapetapp.ui.theme.WallaColTopBar
import com.example.wallapetapp.vm.LocationViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maps(
    navHostController: NavHostController,
    codPostal: String,
    viewModelLoc: LocationViewModel = hiltViewModel()
) {
    //val codPostal="43700"
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { textoBarra(texto = "¿Dónde está?") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = WallaColTopBar
                ),
                navigationIcon = {
                    iconoBarra(navHostController)
                }
            )
        },
        content = { padding ->
            ContenidoMaps(padding, codPostal, viewModelLoc)
        }
    )
}

@Composable
fun ContenidoMaps(padding: PaddingValues, codPostal: String, viewModelLoc: LocationViewModel) {

    val (latitude, longitude) = coordinadasDeCodPostal(codPostal)
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
    val direcciones = geocoder.getFromLocationName(codPostal, 1)

    val direccion = direcciones?.get(0)
    val latitud = direccion?.latitude
    val longitud = direccion?.longitude

    val (latitudeDouble, longitudeDouble) = latLngDouble(latitud, longitud)
    return latitudeDouble to longitudeDouble
}


/*@OptIn(ExperimentalCoroutinesApi::class)
@SuppressLint("MissingPermission")
suspend fun miLocalizacion(context: Context): Location? {

    val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
    //hacer tema pedir permisos
    val isUserLocationPermissionsGranted = true //quitar cuando tengamos tema permisos
    val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    val isGPSEnabled =
        locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.GPS_PROVIDER
        )
    if (!isGPSEnabled || !isUserLocationPermissionsGranted){
        return null
    }

    return suspendCancellableCoroutine { cont ->
        fusedLocationProviderClient.lastLocation.apply {
            if(isComplete){
                if(isSuccessful){
                    cont.resume(result){}
                }else{
                    cont.resume(null){}
                }
                return@suspendCancellableCoroutine
            }
            addOnSuccessListener {
                cont.resume(it){}
            }
            addOnFailureListener {
                cont.resume(null){}
            }
            addOnCanceledListener {
                cont.resume(null){}
            }
        }
    }
}*/

fun latLngDouble(latitud: Double?, longitud: Double?): Pair<Double, Double> {
    val latitudeDouble: Double
    val longitudeDouble: Double
    if (latitud != null) {
        latitudeDouble = latitud * 1
    } else {
        latitudeDouble = 0.0
    }
    if (longitud != null) {
        longitudeDouble = longitud * 1
    } else {
        longitudeDouble = 0.0
    }

    return latitudeDouble to longitudeDouble
}
