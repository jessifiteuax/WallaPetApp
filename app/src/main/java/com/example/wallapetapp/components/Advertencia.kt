package com.example.wallapetapp.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.wallapetapp.domain.model.Mascota

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
                    Text(text = "Eliminar")
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
                    Text(text = "Descartar")
                }
            },
            title = { Text(text = "Eliminar") },
            text = { Text(text = "Seguro que quieres borrar?") },
        )
    }

}