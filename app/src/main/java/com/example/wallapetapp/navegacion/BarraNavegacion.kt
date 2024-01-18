package com.example.wallapetapp.navegacion

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Textsms
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.wallapetapp.ui.theme.WallaColTopBar

@Composable
fun BarraNav() {
    NavigationBar(
        containerColor = WallaColTopBar
    ) {
        NavigationBarItem(
            selected = false,
            onClick = { },
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
            onClick = { },
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