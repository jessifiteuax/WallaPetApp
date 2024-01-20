@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.wallapetapp.pantallas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.wallapetapp.components.BotonPublicar
import com.example.wallapetapp.components.CampoTexto
import com.example.wallapetapp.components.CampoTextoNum
import com.example.wallapetapp.components.ImagenLogo
import com.example.wallapetapp.components.TextoEntrarMascota
import com.example.wallapetapp.components.checkDatosOK
import com.example.wallapetapp.components.textoBarra
import com.example.wallapetapp.navegacion.BarraNav
import com.example.wallapetapp.ui.theme.WallaColTopBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WallaEntraMascota(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { textoBarra(texto = "¡¡¡Me he perdido!!!") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = WallaColTopBar
                )
            )
        },
        bottomBar = { BarraNav(navController) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            ContenidoWallaEntraMascota(Modifier.align(Alignment.Center))
        }

    }
}

@Composable
fun ContenidoWallaEntraMascota(modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var nombre by remember { mutableStateOf("") }
        var poblacion by remember { mutableStateOf("") }
        var codPostal by remember { mutableStateOf("") }
        var mail by remember { mutableStateOf("") }
        var observaciones by remember { mutableStateOf("") }
        var estaChecked: Boolean

        TextoEntrarMascota()
        Spacer(modifier = Modifier.padding(10.dp))
        CampoTexto(nombre, { nombre = it }, "Escribe su nombre si lo sabes")
        Spacer(modifier = Modifier.padding(5.dp))
        CampoTexto(poblacion, { poblacion = it }, "*Población donde está")
        Spacer(modifier = Modifier.padding(5.dp))
        CampoTextoNum(codPostal, { codPostal = it }, "*Código postal")
        Spacer(modifier = Modifier.padding(5.dp))
        CampoTextoNum(mail, { mail = it }, "*e-mail de contacto")
        Spacer(modifier = Modifier.padding(5.dp))
        CampoTexto(observaciones, { observaciones = it }, "Observaciones")
        Spacer(modifier = Modifier.padding(5.dp))

        estaChecked = checkDatosOK(poblacion,codPostal,mail)

        Spacer(modifier = Modifier.padding(5.dp))
        BotonPublicar(Modifier.align(Alignment.End), estaChecked)
    }
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ImagenLogo()
    }
}
