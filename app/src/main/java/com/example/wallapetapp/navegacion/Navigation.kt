package com.example.wallapetapp.navegacion

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.wallapetapp.pantallas.Maps
import com.example.wallapetapp.pantallas.PantallaUpdateMascota
import com.example.wallapetapp.pantallas.WallaAcercaDe
import com.example.wallapetapp.pantallas.WallaEntraMascota
import com.example.wallapetapp.pantallas.WallaHome
import com.example.wallapetapp.pantallas.WallaMascotas
import com.example.wallapetapp.pantallas.WallaRecomendaciones

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            WallaHome(navController)
        }
        composable("EntrarMascotas") {
            WallaEntraMascota(navController)
        }
        composable("AcercaDe") {
            WallaAcercaDe(navController)
        }
        composable("Mascotas") {
            WallaMascotas(navController,
                navigateToPantallaUpdateMascota = { mascotaId ->
                    navController.navigate(
                        "UpdateMascota/$mascotaId"
                    )
                },
                navigateToPantallaMapas = { codPostal ->
                    navController.navigate(
                        "Mapas/$codPostal"
                    )
                },
            )
        }
        composable(
            route = "UpdateMascota/{mascotaId}",
            arguments = listOf(
                navArgument("mascotaId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val mascotaId = backStackEntry.arguments?.getInt("mascotaId") ?: 0
            PantallaUpdateMascota(
                navController,
                mascotaId = mascotaId,
                navigateBack = {
                    navController.popBackStack()
                },
                )
        }
        composable(
            route = "Mapas/{codPostal}",
            arguments = listOf(
                navArgument("codPostal") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val codPostal = backStackEntry.arguments?.getString("codPostal") ?: ""
            Maps(
                navController,
                codPostal = codPostal
            )
        }
        composable("Recomendaciones") {
            WallaRecomendaciones(navController)
        }
    }
}
