package com.example.wallapetapp.navegacion

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.wallapetapp.pantallas.Maps
import com.example.wallapetapp.pantallas.PantallaUpdateMascota
import com.example.wallapetapp.pantallas.TabsView
import com.example.wallapetapp.pantallas.TabsView2
import com.example.wallapetapp.pantallas.WallaAcercaDe
import com.example.wallapetapp.pantallas.WallaEntraMascota
import com.example.wallapetapp.pantallas.WallaHome
import com.example.wallapetapp.pantallas.WallaMascotas

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun navigation(darkmode: MutableState<Boolean>) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            WallaHome(navController, darkmode)
        }
        composable("EntrarMascotas") {
            WallaEntraMascota(navController, darkmode=darkmode)
        }
        composable("AcercaDe") {
            WallaAcercaDe(navController, darkmode)
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
                darkmode=darkmode
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
                darkmode=darkmode
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
                codPostal = codPostal,
                darkmode=darkmode
            )
        }
        composable("Consejos") {
            TabsView(navController, darkmode)
        }
        composable("Contactos") {
            TabsView2(navController, darkmode)
        }
        composable("Tabs") {
            TabsView(navController, darkmode)
        }
    }
}
/*  composable("Consejos") {
            WallaConsejos(navController,darkmode=darkmode)
        }
        composable("Contactos") {
            WallaContactos(navController,darkmode=darkmode)
        }*/