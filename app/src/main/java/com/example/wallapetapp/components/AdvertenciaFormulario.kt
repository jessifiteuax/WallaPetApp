package com.example.wallapetapp.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

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
