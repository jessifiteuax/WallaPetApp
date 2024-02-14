package com.wallapet.wallapetapp.pantallas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.wallapet.wallapetapp.R
import com.wallapet.wallapetapp.components.BotonDarkMode
import com.wallapet.wallapetapp.components.ImagenLogoAcercaDe
import com.wallapet.wallapetapp.navegacion.BarraNav
import com.wallapet.wallapetapp.components.TextoAcercaDe
import com.wallapet.wallapetapp.components.TextoAcercaDe2
import com.wallapet.wallapetapp.components.TextoAcercaDeNombre
import com.wallapet.wallapetapp.components.iconoBarra
import com.wallapet.wallapetapp.components.textoBarra
import com.wallapet.wallapetapp.ui.theme.WallaColTopBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WallaAcercaDe(navController: NavHostController, darkmode: MutableState<Boolean>) {


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { textoBarra(texto = stringResource(R.string.acerca_de_wallapet)) },
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
        content = {
            padding ->
            ContenidoWallaAcercaDe(padding)
        },

        bottomBar = { BarraNav(navController) }
    )
}

@Composable
fun ContenidoWallaAcercaDe(padding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            ImagenLogoAcercaDe()
            Spacer(modifier = Modifier.padding(5.dp))
            Column {
                TextoAcercaDeNombre()
                Spacer(modifier = Modifier.padding(5.dp))
                TextoAcercaDe()
            }
        }
        TextoAcercaDe2()

    }
}








