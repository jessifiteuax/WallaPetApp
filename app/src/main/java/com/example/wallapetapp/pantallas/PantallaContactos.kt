package com.example.wallapetapp.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.wallapetapp.R
import com.example.wallapetapp.components.BotonDarkMode
import com.example.wallapetapp.components.CampoTextoFiltro
import com.example.wallapetapp.components.ContactoCard
import com.example.wallapetapp.components.iconoBarra
import com.example.wallapetapp.components.textoBarra
import com.example.wallapetapp.model.getContactos
import com.example.wallapetapp.navegacion.BarraNav
import com.example.wallapetapp.ui.theme.WallaColTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WallaContactos(navController: NavHostController, darkmode: MutableState<Boolean>) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { textoBarra(texto = stringResource(R.string.contactos)) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = WallaColTopBar
                ),
                actions = {
                    BotonDarkMode(darkMode = darkmode)
                },
                navigationIcon = {
                    iconoBarra(navController)
                }
            )
        },
        content = { padding ->
            ContenidoWallaContactos(padding)
        },
        bottomBar = { BarraNav(navController) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContenidoWallaContactos(padding: PaddingValues) {
    var filtroTexto by remember { mutableStateOf("") }
    val consejosFiltrados = getContactos().filter { contacto ->
        contacto.lugar.contains(filtroTexto, ignoreCase = true) || contacto.descripcion.contains(filtroTexto, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        CampoTextoFiltro(filtroTexto, { filtroTexto = it },
            stringResource(R.string.contacto_a_buscar))
        LazyColumn() {
            items(consejosFiltrados) { contacto ->
                ContactoCard(contacto)
            }
        }
    }
}