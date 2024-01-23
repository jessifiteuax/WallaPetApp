package com.example.wallapetapp.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wallapetapp.pantallas.WallaAcercaDe
import com.example.wallapetapp.pantallas.WallaEntraMascota
import com.example.wallapetapp.pantallas.WallaHome
import com.example.wallapetapp.pantallas.WallaMascotas
import com.example.wallapetapp.viewModel.MascotasViewModel

@Composable
fun navigation(mascotasVM: MascotasViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            WallaHome(navController)
        }
        composable("Mascotas"){
            WallaMascotas(navController, mascotasVM)
        }
        composable("EntrarMascotas") {
            WallaEntraMascota(navController, mascotasVM)
        }
        composable("AcercaDe") {
            WallaAcercaDe(navController)
        }
    }
}