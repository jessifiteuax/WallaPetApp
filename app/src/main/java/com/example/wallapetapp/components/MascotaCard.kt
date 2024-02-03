package com.example.wallapetapp.components

import android.graphics.BitmapFactory
import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.wallapetapp.R
import com.example.wallapetapp.domain.model.Mascota
import com.example.wallapetapp.pantallas.Maps
import com.example.wallapetapp.ui.theme.WallaColTopBar
import java.io.File


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MascotaCard(
    mascota: Mascota,
    navController: NavHostController,
    deleteMascota: () -> Unit,
    navigateToUpdateMascotaScreen: (mascotaId: Int) -> Unit,
    navigateToPantallaMapas: (codPostal: String) -> Unit) {

    var verAlertaBorrado by remember { mutableStateOf(false) }

    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                //PhotoView(imagePath = mascota.foto)
                //Text(text = mascota.foto)

                TextoCardTitulos(texto = stringResource(R.string.nombre))
                TextoCardDatos(texto = mascota.nombre)
                TextoCardTitulos(texto = stringResource(R.string.poblacioncard))
                TextoCardDatos(texto = mascota.poblacion)
                TextoCardTitulos(texto = stringResource(R.string.codigo_postalcard))
                TextoCardDatos(texto = mascota.codPostal)
                TextoCardTitulos(texto = stringResource(R.string.emailcard))
                TextoCardDatos(texto = mascota.mail)
                TextoCardTitulos(texto = stringResource(R.string.observaciones))
                TextoCardDatos(texto = mascota.observaciones)
                TextoCardTitulos(texto = stringResource(R.string.fecha_de_entrada))
                TextoCardDatos(texto = mascota.fecha)
                Spacer(modifier = Modifier.padding(10.dp))
                Divider(
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp), thickness = 5.dp, color = WallaColTopBar
                )

                Row {
                    IconButton(
                        onClick = {navigateToPantallaMapas(mascota.codPostal) },
                        modifier = Modifier.weight(0.5f)
                    ) {
                        Icon(imageVector = Icons.Outlined.LocationOn, contentDescription = "Maps")
                    }


                    IconButton(
                        onClick = { navigateToUpdateMascotaScreen(mascota.id) },
                        modifier = Modifier.weight(0.5f)
                    ) {
                        Icon(imageVector = Icons.Outlined.Edit, contentDescription = "Modificar")
                    }
                    IconButton(
                        onClick = { verAlertaBorrado = true },
                        modifier = Modifier.weight(0.5f)
                    )
                    {
                        Icon(imageVector = Icons.Outlined.Delete, contentDescription = "Borrar")
                        AdvertenciaBorrado(verAlertaBorrado,{verAlertaBorrado=false},deleteMascota)
                    }

                }
            }
        }
    }
}

@Composable
fun PhotoView(imagePath: String) {
    Text(text = "Entro en PhotoView")
    Text(text = imagePath)
    val bitmap = remember {
        try {
            val file = File(imagePath)
            BitmapFactory.decodeFile(file.absolutePath)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
    if (bitmap != null) {

        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = "",
            modifier = Modifier
                .padding(15.dp)
        )
    } else {
        Text(text = "Error al cargar la imagen")
    }
}
//BitmapFactory.decodeResource(getResources(), R.id.arrow)


