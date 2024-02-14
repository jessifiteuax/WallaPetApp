package com.example.wallapetapp.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.wallapetapp.R
import com.example.wallapetapp.ui.theme.CaveatFamily

@Composable
fun TextoHome() {
    Text(
        text = stringResource(R.string.bienvenida) + "\n",
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
fun TextoAcercaDe() {
    Text(
        text = stringResource(R.string.wallapetapp_versi_n_1_0_0) +
                stringResource(R.string.aplicaci_n_dise_ada_para_sistemas_android),
        fontSize = 24.sp,
        fontFamily = CaveatFamily
    )
}

@Composable
fun TextoAcercaDe2() {
    Text(
        text = stringResource(R.string.dise_ado_por_wallapet_company_para_mantener_la_comunidad_animal_unida) +
                stringResource(R.string.puedes_hacer_cualquier_sugerencia_mandando_un_correo_a_opina_wallapet_com),
        fontSize = 24.sp,
        fontFamily = CaveatFamily
    )
}

@Composable
fun TextoAcercaDeNombre() {
    Text(
        text = stringResource(R.string.app_name),
        fontSize = 24.sp,
        fontFamily = CaveatFamily
   )
}

@Composable
fun TextoCardTitulos(texto: String) {
    Text(
        text = texto,
        fontSize = 24.sp,
        fontFamily = CaveatFamily,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline
    )
}

@Composable
fun TextoCardDatos(texto: String) {
    Text(
        text = texto,
        fontSize = 24.sp,
        fontFamily = CaveatFamily
    )
}

@Composable
fun TextoUpdateMascota() {
    Text(
        text = stringResource(R.string.modifica_los_datos_necesarios),
        fontSize = 24.sp,
        fontFamily = CaveatFamily
    )
}
