@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.wallapetapp.pantallas

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUpOffAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.wallapetapp.R
import com.example.wallapetapp.components.CampoTexto
import com.example.wallapetapp.components.CampoTextoNum
import com.example.wallapetapp.components.ImagenLogo
import com.example.wallapetapp.components.TextoEntrarMascota
import com.example.wallapetapp.components.checkDatosOK
import com.example.wallapetapp.components.iconoBarra
import com.example.wallapetapp.components.textoBarra
import com.example.wallapetapp.fotos.createImageFile
import com.example.wallapetapp.navegacion.BarraNav
import com.example.wallapetapp.ui.theme.WallaColTopBar
import java.time.LocalDate
import java.util.Objects

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WallaEntraMascota(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { textoBarra(texto = stringResource(R.string.me_he_perdido)) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = WallaColTopBar
                ),
                navigationIcon = {
                    iconoBarra(navController)
                }
            )
        },
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                ContenidoWallaEntraMascota(padding, navController)
            }
        },
        bottomBar = { BarraNav(navController) }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ContenidoWallaEntraMascota(
    padding: PaddingValues,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var nombre by remember { mutableStateOf("") }
        var poblacion by remember { mutableStateOf("") }
        var codPostal by remember { mutableStateOf("") }
        var mail by remember { mutableStateOf("") }
        var observaciones by remember { mutableStateOf("") }
        //var fecha by remember { mutableStateOf("")  }
        val estaChecked: Boolean

        TextoEntrarMascota()
        Spacer(modifier = Modifier.padding(5.dp))
        CampoTexto(nombre, { nombre = it }, stringResource(R.string.escribe_nombre))
        Spacer(modifier = Modifier.padding(5.dp))
        CampoTexto(poblacion, { poblacion = it }, stringResource(R.string.poblacion))
        Spacer(modifier = Modifier.padding(5.dp))
        CampoTextoNum(codPostal, { codPostal = it }, stringResource(R.string.codigo_postal))
        Spacer(modifier = Modifier.padding(5.dp))
        CampoTexto(mail, { mail = it }, stringResource(R.string.email))
        Spacer(modifier = Modifier.padding(5.dp))
        CampoTexto(observaciones, { observaciones = it }, stringResource(R.string.observaciones))
        Spacer(modifier = Modifier.padding(5.dp))
        ImagenCamara()
        estaChecked = checkDatosOK(poblacion, codPostal, mail)
        //BotonPublicar(estaChecked)
        Button(
            onClick = {

               // navController.popBackStack()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC03D69),
                contentColor = Color.White
            ),
            modifier = Modifier.padding(10.dp),
            enabled = estaChecked
        ) {
            Icon(
                imageVector = Icons.Filled.ThumbUpOffAlt,
                tint = Color.White,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = stringResource(R.string.publicar),
                fontSize = 16.sp
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

@Composable
fun ImagenCamara() {

    val context = LocalContext.current
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
            modifier = Modifier
                .weight(1f)
                .padding(22.dp),
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
            Text(text = stringResource(R.string.hazle_una_foto))
        }
        Spacer(modifier = Modifier.width(5.dp))
        Image(
            modifier = Modifier
                .size(80.dp)
                .weight(0.7f),
            painter = rememberAsyncImagePainter(if (image.path?.isNotEmpty() == true) image else imageDefault),
            contentDescription = null
        )
    }
}
