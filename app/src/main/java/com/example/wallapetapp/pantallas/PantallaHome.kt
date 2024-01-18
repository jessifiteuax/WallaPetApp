@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.wallapetapp.pantallas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wallapetapp.navegacion.BarraNav
import com.example.wallapetapp.components.BotonEntrarMascotas
import com.example.wallapetapp.components.BotonVerMascotas
import com.example.wallapetapp.components.ImagenLogo
import com.example.wallapetapp.components.TextoHome
import com.example.wallapetapp.components.textoBarra
import com.example.wallapetapp.ui.theme.WallaColTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WallaHome() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { textoBarra(texto = "Wallapet Home") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = WallaColTopBar
                )
            )
        },
        bottomBar = { BarraNav() }
    ) {
        ContenidoWallaHome()
    }
}

@Composable
fun ContenidoWallaHome() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextoHome()
        Spacer(modifier = Modifier.padding(32.dp))
        BotonVerMascotas()
        Spacer(modifier = Modifier.padding(16.dp))
        BotonEntrarMascotas()
    }
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Center
    ) {
        ImagenLogo()
    }
}









