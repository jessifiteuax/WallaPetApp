package com.example.wallapetapp.model

data class Contacto(var lugar:String, var descripcion:String ,var telefono:String, var mail:String)

fun getContactos(): List<Contacto> {
    return listOf(
        Contacto("AIAC",
            "Archivo de Indentificación de Animales de Compañía",
            "+34934189294",
            "aiac@veterinaris.cat"),
        Contacto("ANICOM",
            "Registro General de Animales de Compañía",
            "+34935617000",
            "anicom.tes@gencat.cat "),
        Contacto("REIAC",
            "Red Española de Identificación de Animales de Compañía",
            "+34954542701",
            "reiac@reiac.es"),
        Contacto("Seprona",
            "Servicio de Protección de la Naturaleza (Guardia Civil)",
            "062",
            "seprona@guardiacivial.es"),
        Contacto("Emergencias",
        "Policía, Bomberos, ...",
        "112",
        "")
    )
}