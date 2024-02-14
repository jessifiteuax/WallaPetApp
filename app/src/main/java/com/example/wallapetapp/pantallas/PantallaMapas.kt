package com.example.wallapetapp.pantallas

import MiLocalizacion
import android.location.Geocoder
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.wallapetapp.R
import com.example.wallapetapp.components.BotonDarkMode
import com.example.wallapetapp.components.iconoBarra
import com.example.wallapetapp.components.textoBarra
import com.example.wallapetapp.ui.theme.WallaColTopBar
import com.example.wallapetapp.vm.LocationViewModel
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerInfoWindowContent
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maps(
    navHostController: NavHostController,
    codPostal: String,
    darkmode: MutableState<Boolean>,
    viewModelLoc: LocationViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { textoBarra(texto = "¿Dónde está?") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = WallaColTopBar
                ),
                actions = {
                    BotonDarkMode(darkMode = darkmode)
                },
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
    MiLocalizacion()
    val miLatitud = viewModelLoc.latitude.collectAsState().value
    val miLongitud = viewModelLoc.longitude.collectAsState().value
    val miLugar = LatLng(miLatitud, miLongitud)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(lugar, 10f)
    }
    var mapLoading by remember { mutableStateOf(true) }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(padding)){
        GoogleMap(
            modifier = Modifier.matchParentSize(),
            cameraPositionState = cameraPositionState,
            onMapLoaded = {
                mapLoading = false
            }
        ) {
            MarkerInfoWindowContent(
                state = MarkerState(position = lugar),
                icon = BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher_round),
                title = stringResource(R.string.mascota),
                snippet = stringResource(R.string.poblaci_n_donde_se_encuentra_la_mascota)
            )
            MarkerInfoWindowContent(
                state = MarkerState(position = miLugar),
                icon = BitmapDescriptorFactory.fromResource(R.drawable.icons8_brazos_arriba_48),
                title = stringResource(R.string.tu_ubicaci_n),
                snippet = stringResource(R.string.aqu_te_encuentras_t)
            )
        }
        if(mapLoading){
            AnimatedVisibility(
                visible = mapLoading,
                modifier = Modifier.matchParentSize(),
                enter = EnterTransition.None,
                exit = fadeOut()
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.wrapContentSize()
                    )
            }
        }
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
