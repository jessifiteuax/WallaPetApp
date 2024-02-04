package com.example.wallapetapp.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.wallapetapp.R
import com.example.wallapetapp.components.MascotaCard
import com.example.wallapetapp.components.TextoRecDescripcion
import com.example.wallapetapp.components.TextoRecTitulo
import com.example.wallapetapp.components.iconoBarra
import com.example.wallapetapp.components.textoBarra
import com.example.wallapetapp.navegacion.BarraNav
import com.example.wallapetapp.ui.theme.WallaColTopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WallaConsejos(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { textoBarra(texto = "Consejos") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = WallaColTopBar
                ),
                navigationIcon = {
                    iconoBarra(navController)
                }
            )
        },
        content = {
                padding ->
            ContenidoWallaConsejos(padding)
        },
        bottomBar = { BarraNav(navController) }
    )
}

@Composable
fun ContenidoWallaConsejos(padding: PaddingValues) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        //filtro
        Card(
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        ) {
            Column {
                TextoRecTitulo(texto = "Petardos")
                TextoRecDescripcion(texto = "Descripcion petardos")
            }
        }
    }
}




