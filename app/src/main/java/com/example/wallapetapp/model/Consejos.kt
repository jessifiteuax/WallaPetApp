package com.example.wallapetapp.model

import androidx.compose.runtime.Composable

data class Consejo(var titulo: String, var descripcion: String, var webReferencia: String)


fun getConsejos(): List<Consejo> {
    return listOf(
        Consejo(
            "Petardos",
            "- No dejar al animal solo en casa\n- Mantener la calma y tratar de transmitirsela\n- Generar otro tipo de ruidos para tapar el sonido de los petardos\n- Medicamentos naturales que dismunuyen el estrés\n- Ropa tranquilizadora\n-Distraerlo con premios\n- Contactar con educadores caninos",
            "https://www.srperro.com/consejos/salud-perruna/consejos-para-calmar-a-los-perros-en-epoca-de-petardos"
        ),
        Consejo("Contacto con la procesionaria",
            "- Sacar el animal de la zona donde haya las orugas\n- Abrirle la boca para observar el estado de la lengua\n- Lavar la zona con suero fisiológico o agua evitando que se la trague\n- No frotar la zona afextada\n- Acudir al veterinario",
            "https://www.srperro.com/consejos/salud-perruna/que-hacer-si-tu-perro-entra-en-contacto-con-la-oruga-procesionaria/"

        )/*,
        Consejo("","",""

        ),
        Consejo("","",""

        ),
        Consejo("","",""

        ),*/

        )
}



