import android.Manifest
import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wallapetapp.vm.LocationViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.location.LocationServices

private const val REQUEST_LOCATION_PERMISSION_CODE = 1001


@Composable
fun MiLocalizacion(locationViewModel: LocationViewModel = viewModel()) {
    var latitude by remember { mutableStateOf(0.0) }
    var longitude by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RequestLocationPermissionAndGetCurrentLocation { location ->
            latitude = location.first
            longitude = location.second
            locationViewModel.setLocation(latitude, longitude)
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RequestLocationPermissionAndGetCurrentLocation(
    onPermissionGranted: (Pair<Double, Double>) -> Unit
) {
    val context = LocalContext.current
    val activity = LocalContext.current as ComponentActivity
    val locationPermissionState = rememberPermissionState(
        android.Manifest.permission.ACCESS_FINE_LOCATION
    )

    LaunchedEffect(locationPermissionState) {
        if (locationPermissionState.status.isGranted) {
            getLocation(activity, onPermissionGranted)
        } else {
            ActivityCompat.requestPermissions(
                activity,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION_PERMISSION_CODE
            )
        }
    }

    val onRequestPermissionsResult = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            getLocation(activity, onPermissionGranted)
        }
    }

    DisposableEffect(locationPermissionState) {
        onRequestPermissionsResult.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        onDispose {}
    }
}

@SuppressLint("MissingPermission")
private fun getLocation(context: ComponentActivity, onPermissionGranted: (Pair<Double, Double>) -> Unit) {
    val locationClient = LocationServices.getFusedLocationProviderClient(context)
    locationClient.lastLocation.addOnSuccessListener { location ->
        if (location != null) {
            onPermissionGranted(Pair(location.latitude, location.longitude))
        }
    }
}


