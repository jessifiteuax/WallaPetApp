package com.example.wallapetapp.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import com.example.wallapetapp.components.ConsejoCard
import com.example.wallapetapp.components.iconoBarra
import com.example.wallapetapp.components.textoBarra
import com.example.wallapetapp.model.getConsejos
import com.example.wallapetapp.navegacion.BarraNav
import com.example.wallapetapp.ui.theme.WallaColTopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WallaConsejos(navController: NavHostController, darkmode: MutableState<Boolean>) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { textoBarra(texto = stringResource(R.string.consejos)) },
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
            ContenidoWallaConsejos(padding)
        },
        bottomBar = { BarraNav(navController) }
    )
}


@Composable
fun ContenidoWallaConsejos(padding: PaddingValues) {
    var filtroTexto by remember { mutableStateOf("") }
    val consejosFiltrados = getConsejos().filter {consejo ->
        consejo.titulo.contains(filtroTexto, ignoreCase = true) || consejo.descripcion.contains(filtroTexto, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        CampoTextoFiltro(filtroTexto, { filtroTexto = it },
            stringResource(R.string.consejo_a_buscar))
               LazyColumn() {
            items(consejosFiltrados) { consejo ->
                ConsejoCard(consejo)
            }
        }
    }
}


