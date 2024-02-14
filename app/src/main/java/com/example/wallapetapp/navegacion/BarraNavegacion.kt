package com.example.wallapetapp.navegacion

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.wallapetapp.R
import com.example.wallapetapp.components.textoBarraBottom
import com.example.wallapetapp.ui.theme.WallaColTopBar

@Composable
fun BarraNav(navController: NavHostController) {
    NavigationBar(
        containerColor = WallaColTopBar,
        tonalElevation = 10.dp

    ) {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("Home") },
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                    textoBarraBottom(texto = stringResource(R.string.home))
                }
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("AcercaDe") },
            icon = {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = "AcercaDe",
                        tint = Color.White
                    )
                    textoBarraBottom(texto = stringResource(R.string.acerca_de_wallapet))
                }
            }
        )

       /* NavigationBarItem(
         selected = false,
         onClick = { navController.navigate("Recomendaciones") },
         icon = {
             Column(
                 horizontalAlignment = Alignment.CenterHorizontally
             ) {
                 Icon(
                     imageVector = Icons.Default.Home,
                     contentDescription = "Consejos",
                     tint = Color.White
                 )
                 textoBarraBottom("Consejos")
             }
         }
     )*/
    }
}