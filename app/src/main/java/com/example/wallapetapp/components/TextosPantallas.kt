package com.example.wallapetapp.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.wallapetapp.R
import com.example.wallapetapp.ui.theme.CaveatFamily

@Composable
fun TextoHome() {
    Text(
        text = stringResource(R.string.bienvenida)+"\n",
        fontSize = 24.sp,
        fontFamily = CaveatFamily,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = stringResource(R.string.subbienvenida),
        fontSize = 24.sp,
        fontFamily = CaveatFamily
    )
}

@Composable
fun TextoEntrarMascota() {
    Text(
        text = stringResource(R.string.que_mascota_has_encontrado),
        fontSize = 24.sp,
        fontFamily = CaveatFamily
    )
}

@Composable
fun TextoAcercaDe(){
    Text(
        text = stringResource(R.string.texto_acerca_de),
        fontSize = 24.sp,
        fontFamily = CaveatFamily
    )
}