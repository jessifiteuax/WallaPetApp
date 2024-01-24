package com.example.wallapetapp.navegacion

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wallapetapp.pantallas.WallaAcercaDe
import com.example.wallapetapp.pantallas.WallaEntraMascota
import com.example.wallapetapp.pantallas.WallaHome
import com.example.wallapetapp.pantallas.WallaMascotas

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            WallaHome(navController)
        }
        composable("Mascotas"){
            WallaMascotas(navController)
        }
        composable("EntrarMascotas") {
            WallaEntraMascota(navController)
        }
        composable("AcercaDe") {
            WallaAcercaDe(navController)
        }
    }
}