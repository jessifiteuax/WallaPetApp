package com.example.wallapetapp.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.wallapetapp.ui.theme.CaveatFamily

@Composable
fun TextoRecTitulo(texto:String) {
    Text(fontSize = 24.sp,
        fontFamily = CaveatFamily,
        fontWeight = FontWeight.Bold,
        text = texto)
}

@Composable
fun TextoRecDescripcion(texto:String) {
    Text(fontSize = 24.sp,
        fontFamily = CaveatFamily,
        text = texto)
}