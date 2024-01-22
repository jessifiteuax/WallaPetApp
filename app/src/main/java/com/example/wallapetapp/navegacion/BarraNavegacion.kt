package com.example.wallapetapp.navegacion

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Textsms
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
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
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Search",
                    tint = Color.White
                )
            }


        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("AcercaDe") },
            icon = {
                Icon(
                    imageVector = Icons.Default.Textsms,
                    contentDescription = "AcercaDe",
                    tint = Color.White
                )
            }
        )
    }
}