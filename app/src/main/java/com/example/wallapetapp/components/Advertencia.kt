package com.example.wallapetapp.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.wallapetapp.R

@Composable
fun Advertencia(
    titulo: String,
    mensaje: String,
    textoConfirm: String,
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissClick,
        title = { Text(text = titulo) },
        text = { Text(text = mensaje) },
        confirmButton = {
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFC03D69),
                    contentColor = Color.White,
                ),
                onClick = { onConfirmClick() }
            ) {
                Text(text = textoConfirm)
            }
        }
    )
}

@Composable
fun AdvertenciaBorrado(
    verAlertaBorrado: Boolean,
    onDismissClick: () -> Unit,
    onConfirmClick: () -> Unit
) {
    if (verAlertaBorrado) {
        AlertDialog(
            onDismissRequest = { onDismissClick() },
            confirmButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFFC03D69),
                        contentColor = Color.White,
                    ),
                    onClick = { onConfirmClick() }
                ) {
                    Text(text = stringResource(R.string.eliminar))
                }
            },
            dismissButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFFC03D69),
                        contentColor = Color.White,
                    ),
                    onClick = { onDismissClick() }
                ) {
                    Text(text = stringResource(R.string.descartar))
                }
            },
            title = { Text(text = stringResource(R.string.eliminar)) },
            text = { Text(text = stringResource(R.string.seguro_que_quieres_borrar)) },
        )
    }

}