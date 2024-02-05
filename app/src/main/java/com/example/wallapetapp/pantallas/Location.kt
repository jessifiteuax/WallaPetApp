import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun coordenadas(){

    Column{
        val (latitud, longitud) = LocationScreen()
        Spacer(modifier = Modifier.padding(50.dp))
        Text(text = "mi latitud es $latitud")
        Text(text= "mi longitud es $longitud")
    }


}

@SuppressLint("MissingPermission")
@ExperimentalPermissionsApi
@Composable
fun LocationScreen():Pair<Double,Double> {
    val permissionState = rememberPermissionState(
        permission = Manifest.permission.ACCESS_FINE_LOCATION
    )

    val locationManager = LocalContext.current.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    val lastLocation: Location?
    val currentLocation: Location?
    var latitude: Double = 0.0
    var longitude: Double= 0.0

    if (permissionState.status == PermissionStatus.Granted) {
        lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        currentLocation = lastLocation ?: locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

        if (currentLocation != null) {
            latitude = currentLocation.latitude
            longitude = currentLocation.longitude
            Text(text = "Latitude: $latitude, Longitude: $longitude")

        } else {
            Text(text = "Location not found")
        }
    }
    return (latitude to longitude)
}

