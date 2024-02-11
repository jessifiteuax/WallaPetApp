package com.example.wallapetapp.pantallas

import android.annotation.SuppressLint
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.wallapetapp.R
import com.example.wallapetapp.components.BotonDarkMode
import com.example.wallapetapp.components.CampoTexto
import com.example.wallapetapp.components.CampoTextoFiltro
import com.example.wallapetapp.components.MascotaCard
import com.example.wallapetapp.components.iconoBarra
import com.example.wallapetapp.components.textoBarra
import com.example.wallapetapp.domain.model.Mascota
import com.example.wallapetapp.domain.repository.Mascotas
import com.example.wallapetapp.navegacion.BarraNav
import com.example.wallapetapp.ui.theme.CaveatFamily
import com.example.wallapetapp.ui.theme.WallaColTopBar
import com.example.wallapetapp.vm.MascotasViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WallaMascotas(
    navController: NavHostController,
    navigateToPantallaUpdateMascota: (mascotaId: Int) -> Unit,
    navigateToPantallaMapas: (codPostal: String) -> Unit,
    viewModel: MascotasViewModel = hiltViewModel(),
    darkmode: MutableState<Boolean>
) {
    val mascotas by viewModel.mascotas.collectAsState(initial = emptyList())
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { textoBarra(texto = stringResource(R.string.mascotas)) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = WallaColTopBar,
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
            ContenidoWallaMascotas(

                padding = padding,
                mascotas = mascotas,
                navController = navController,
                deleteMascota = { mascota ->
                    viewModel.deleteMascota(mascota)
                },
                navigateToPantallaUpdateMascota = navigateToPantallaUpdateMascota,
                navigateToPantallaMapas = navigateToPantallaMapas
            )
        },
        bottomBar = { BarraNav(navController = navController) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContenidoWallaMascotas(
    padding: PaddingValues,
    mascotas: Mascotas,
    navController: NavHostController,
    deleteMascota: (mascota: Mascota) -> Unit,
    navigateToPantallaUpdateMascota: (mascotaId: Int) -> Unit,
    navigateToPantallaMapas: (codPostal: String) -> Unit
) {
    var filtroCodPostal by remember { mutableStateOf("") }
    val datosFiltrados = mascotas.filter { it.codPostal == filtroCodPostal }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        CampoTextoFiltro(filtroCodPostal, { filtroCodPostal = it }, stringResource(R.string.Filtrar_codigo_postal))
        LazyColumn{
            items(if (filtroCodPostal.isEmpty()) mascotas else datosFiltrados) { mascota ->
               MascotaCard(
                   mascota = mascota,
                   navController= navController,
                   deleteMascota = { deleteMascota(mascota) },
                   navigateToUpdateMascotaScreen = navigateToPantallaUpdateMascota,
                   navigateToPantallaMapas = navigateToPantallaMapas
               )
            }
        }
    }
}

