@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.wallapetapp.pantallas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.wallapetapp.components.BotonDarkMode
import com.example.wallapetapp.navegacion.BarraNav
import com.example.wallapetapp.components.BotonEntrarMascotas
import com.example.wallapetapp.components.BotonVerConsejos
import com.example.wallapetapp.components.BotonVerContactos
import com.example.wallapetapp.components.BotonVerMascotas
import com.example.wallapetapp.components.ImagenLogo
import com.example.wallapetapp.components.TextoHome
import com.example.wallapetapp.components.textoBarra
import com.example.wallapetapp.ui.theme.WallaColTopBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WallaHome(navController: NavHostController, darkmode: MutableState<Boolean>) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { textoBarra(texto = "Wallapet Home") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = WallaColTopBar
                ),
                actions = {
                    BotonDarkMode(darkMode = darkmode)
                }
            )
        },
        content = {
            ContenidoWallaHome(navController, darkmode)
        },
        bottomBar = { BarraNav(navController) }
    )
}

@Composable
fun ContenidoWallaHome(navController: NavHostController, darkmode: MutableState<Boolean>) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextoHome()
        Spacer(modifier = Modifier.padding(32.dp))
        BotonVerMascotas(navController)
        Spacer(modifier = Modifier.padding(16.dp))
        BotonEntrarMascotas(navController)
        Spacer(modifier = Modifier.padding(16.dp))
        BotonVerConsejos(navController)
        Spacer(modifier = Modifier.padding(16.dp))
        BotonVerContactos(navController)
        //Spacer(modifier = Modifier.padding(16.dp))
       // BotonDarkMode(darkMode = darkmode)
    }
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Center
    ) {
        ImagenLogo()
    }
}









