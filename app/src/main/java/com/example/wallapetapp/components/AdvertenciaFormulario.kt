package com.example.wallapetapp.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

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
            Button(onClick = { onConfirmClick() }) {
                Text(text = textoConfirm)
            }
        }
    )
}
