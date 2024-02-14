package com.wallapet.wallapetapp.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.wallapet.wallapetapp.R

data class Contacto(var lugar:String, var descripcion:String ,var telefono:String, var mail:String)

@Composable
fun getContactos(): List<Contacto> {
    return listOf(
        Contacto("AIAC",
            stringResource(R.string.archivo_de_indentificaci_n_de_animales_de_compa_a),
            "+34934189294",
            "aiac@veterinaris.cat"),
        Contacto("ANICOM",
            stringResource(R.string.registro_general_de_animales_de_compa_a),
            "+34935617000",
            "anicom.tes@gencat.cat "),
        Contacto("REIAC",
            stringResource(R.string.red_espa_ola_de_identificaci_n_de_animales_de_compa_a),
            "+34954542701",
            "reiac@reiac.es"),
        Contacto("Seprona",
            stringResource(R.string.servicio_de_protecci_n_de_la_naturaleza_guardia_civil),
            "062",
            "seprona@guardiacivial.es"),
        Contacto(
            stringResource(R.string.emergencias),
            stringResource(R.string.polic_a_bomberos),
        "112",
        "")
    )
}