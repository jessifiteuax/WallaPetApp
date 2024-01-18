package com.example.wallapetapp.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.wallapetapp.ui.theme.CaveatFamily

@Composable
fun TextoHome() {
    Text(
        text = "Bienvenido a WALLAPET\n",
        fontSize = 24.sp,
        fontFamily = CaveatFamily,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = "¿Qué buena acción vas a hacer?",
        fontSize = 24.sp,
        fontFamily = CaveatFamily
    )
}

@Composable
fun TextoEntrarMascota() {
    Text(
        text = "¿Qué mascota has encontrado perdida?",
        fontSize = 24.sp,
        fontFamily = CaveatFamily
    )
}

@Composable
fun TextoAcercaDe(){
    Text(
        text = "Texto Acerca De",
        fontSize = 24.sp,
        fontFamily = CaveatFamily
    )
}