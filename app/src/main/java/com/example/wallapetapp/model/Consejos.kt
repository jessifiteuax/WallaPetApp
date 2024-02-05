package com.example.wallapetapp.model

import androidx.compose.runtime.Composable

data class Consejo(var titulo: String, var descripcion: String, var webReferencia: String)


fun getConsejos(): List<Consejo> {
    return listOf(
        Consejo(
            "Petardos",
            "- No dejar a la mascota sola en casa\n- Mantener la calma y tratar de transmitírsela\n- Generar otro tipo de ruidos para tapar el sonido de los petardos\n- Medicamentos naturales que dismunuyen el estrés\n- Ropa tranquilizadora\n-Distraerla con premios\n- Contactar con educadores caninos",
            "https://www.srperro.com/consejos/salud-perruna/consejos-para-calmar-a-los-perros-en-epoca-de-petardos"
        ),
        Consejo(
            "Contacto con la procesionaria",
            "- Sacar la mascota de la zona donde haya las orugas\n- Abrirle la boca para observar el estado de la lengua\n- Lavar la zona con suero fisiológico o agua evitando que se la trague\n- No frotar la zona afextada\n- Acudir al veterinario",
            "https://www.srperro.com/consejos/salud-perruna/que-hacer-si-tu-perro-entra-en-contacto-con-la-oruga-procesionaria/"

        ),
        Consejo(
            "Alimentos a evitar",
            "- El chocolate. Cuanto más negro sea el chocolate, más toxicidad\n- Cebolla y ajo\n- Cualquier alimento con cafeína\n- Uvas y uvas pasas\n- Nueces de pecán\n- Cualquier alimento con xilitol\n- Huesos y pepitas de fruta\n- Aguacate\n- Bebidas que contengan alcohol\n- Lácteos",
            "https://www.srperro.com/consejos/nutricion/que-alimentos-son-peligrosos-o-venenosos-para-los-perros/"

        ),
        Consejo(
            "En la nieve",
            "- Ten a tu mascota siempre a la vista\n- Procura que siempre lleve algún tipo de identificación\n- Usa protector de piel en las zonas más expuestas al sol\n- Lleva una toalla para limpiarle las patas de vez en cuando\n- Evita que coma nieve",
            "https://www.srperro.com/consejos/salud-perruna/nieve-frio-y-perros-algunos-consejos-basicos-para-los-paseos-de-invierno/"

        ),
        Consejo(
            "En la playa",
            "- Nunca tires a tu mascota al agua si no quiere meterse\n- Tener algún sitio con sombra para que pueda refugiarse del calor excesivo\n- Intentar evitar que beba agua salada\n- Vigilar con las corrientes\n- Llevar siemrpe agua dulce y hacer que beban con frecuencia",
            "https://www.srperro.com/consejos/salud-perruna/chapuzones-perrunos-sin-sustos-consejos-para-un-buen-dia-de-playa-o-piscina/"

        ),

        )
}



