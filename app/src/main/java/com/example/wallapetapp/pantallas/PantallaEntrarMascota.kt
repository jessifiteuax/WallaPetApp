@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.wallapetapp.pantallas

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.wallapetapp.R
import com.example.wallapetapp.components.BotonPublicar
import com.example.wallapetapp.components.CampoTexto
import com.example.wallapetapp.components.CampoTextoNum
import com.example.wallapetapp.components.ImagenLogo
import com.example.wallapetapp.components.TextoEntrarMascota
import com.example.wallapetapp.components.checkDatosOK
import com.example.wallapetapp.components.textoBarra
import com.example.wallapetapp.fotos.createImageFile
import com.example.wallapetapp.navegacion.BarraNav
import com.example.wallapetapp.ui.theme.WallaColTopBar
import java.util.Objects

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
        //Spacer(modifier = Modifier.padding(10.dp))
        CampoTexto(nombre, { nombre = it }, "Escribe su nombre si lo sabes")
        Spacer(modifier = Modifier.padding(5.dp))
        CampoTexto(poblacion, { poblacion = it }, "*Población donde está")
        Spacer(modifier = Modifier.padding(5.dp))
        CampoTextoNum(codPostal, { codPostal = it }, "*Código postal")
        Spacer(modifier = Modifier.padding(5.dp))
        CampoTextoNum(mail, { mail = it }, "*e-mail de contacto")
        Spacer(modifier = Modifier.padding(5.dp))
        CampoTexto(observaciones, { observaciones = it }, "Observaciones")
        //Spacer(modifier = Modifier.padding(5.dp))
        imagenCamara()
        estaChecked = checkDatosOK(poblacion,codPostal,mail)
        BotonPublicar(Modifier.align(Alignment.End), estaChecked)
    }
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ImagenLogo()
    }
}

@Composable
fun imagenCamara() {

    val context = LocalContext.current
    //val clipboard = LocalClipboardManager.current
    val file = context.createImageFile()
    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        context.packageName + ".provider", file
    )
    var image by remember { mutableStateOf<Uri>(Uri.EMPTY) }
    val imageDefault = R.drawable.fotodefecto
    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
            image = uri
        }
    val permissionLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                Toast.makeText(context, "Permiso concedido", Toast.LENGTH_SHORT).show()
                cameraLauncher.launch(uri)
            } else {
                Toast.makeText(context, "Permiso denegado", Toast.LENGTH_SHORT).show()
            }
        }
    Row {
        Button(
            modifier = Modifier.weight(1f).padding(22.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC03D69),
                contentColor = Color.White
            ),
            onClick = {
                val permissionCheckResult =
                    ContextCompat.checkSelfPermission(context, android.Manifest.permission.CAMERA)
                if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
                    cameraLauncher.launch(uri)
                } else {
                    permissionLauncher.launch(android.Manifest.permission.CAMERA)
                }
            }) {
            Text(text = "¡Hazle una foto!")
        }
        Spacer(modifier = Modifier.width(5.dp))
        Image(
            modifier= Modifier.size(80.dp).weight(0.7f),
            painter = rememberAsyncImagePainter(if (image.path?.isNotEmpty() == true) image else imageDefault),
            contentDescription = null
        )
    }
}
