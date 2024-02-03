package com.example.wallapetapp.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.wallapetapp.R
import com.example.wallapetapp.components.CampoTexto
import com.example.wallapetapp.components.CampoTextoNum
import com.example.wallapetapp.components.ImagenLogo
import com.example.wallapetapp.components.TextoUpdateMascota
import com.example.wallapetapp.components.checkDatosOK
import com.example.wallapetapp.components.iconoBarra
import com.example.wallapetapp.components.textoBarra
import com.example.wallapetapp.domain.model.Mascota
import com.example.wallapetapp.ui.theme.WallaColTopBar
import com.example.wallapetapp.vm.MascotasViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaUpdateMascota(
    navHostController: NavHostController,
    viewModel: MascotasViewModel = hiltViewModel(),
    mascotaId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getMascota(mascotaId)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { textoBarra(texto = stringResource(R.string.actualiza_datos)) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = WallaColTopBar
                ),
                navigationIcon = {
                    iconoBarra(navHostController)
                }
            )
        },
        content = { padding ->
            ContenidoMascota(
                padding = padding,
                mascota = viewModel.mascota,
                updateNombre = { nombre ->
                    viewModel.updateNombre(nombre)
                },
                updatePoblacion = { poblacion ->
                    viewModel.updatePoblacion(poblacion)
                },
                updateCodPostal = { codPostal ->
                    viewModel.updateCodPostal(codPostal)
                },
                updateMail = { mail ->
                    viewModel.updateMail(mail)
                },
                updateObservaciones = { observaciones ->
                    viewModel.updateObservaciones(observaciones)
                },
                updateMascota = { mascota ->
                    viewModel.updateMascota(mascota)
                },
                navigateBack = navigateBack
            )
        }
    )
}

@Composable
fun ContenidoMascota(
    padding: PaddingValues,
    mascota: Mascota,
    updateNombre: (nombre: String) -> Unit,
    updatePoblacion: (poblacion: String) -> Unit,
    updateCodPostal: (codPostal: String) -> Unit,
    updateMail: (mail: String) -> Unit,
    updateObservaciones: (observaciones: String) -> Unit,
    updateMascota: (mascota: Mascota) -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextoUpdateMascota()
        Spacer(modifier = Modifier.padding(30.dp))
        CampoTexto(
            mascota.nombre,
            { nombre -> updateNombre(nombre) },
            stringResource(R.string.escribe_nombre)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        CampoTexto(
            mascota.poblacion,
            { poblacion -> updatePoblacion(poblacion) },
            stringResource(R.string.poblacion)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        CampoTextoNum(
            mascota.codPostal,
            { codPostal -> updateCodPostal(codPostal) },
            stringResource(R.string.codigo_postal)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        CampoTexto(mascota.mail, { mail -> updateMail(mail) }, stringResource(R.string.email))
        Spacer(modifier = Modifier.padding(5.dp))
        CampoTexto(
            mascota.observaciones,
            { observaciones -> updateObservaciones(observaciones) },
            stringResource(R.string.observaciones)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        val estaChecked: Boolean = checkDatosOK(mascota.poblacion, mascota.codPostal, mascota.mail)

        Button(
            onClick = {
                updateMascota(mascota)
                navigateBack()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC03D69),
                contentColor = Color.White
            ),
            modifier = Modifier.padding(10.dp),
            enabled = estaChecked
        ) {
            Icon(
                imageVector = Icons.Filled.Pets,
                tint = Color.White,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = stringResource(R.string.actualizar),
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.width(5.dp))
            Icon(
                imageVector = Icons.Filled.Pets,
                tint = Color.White,
                contentDescription = ""
            )
        }
    }
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ImagenLogo()
    }
}