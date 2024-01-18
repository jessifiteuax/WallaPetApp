package com.example.wallapetapp.items

import androidx.annotation.DrawableRes

data class Mascotas(
    var nombre: String = "Sin nombre conocido",
    var poblacion: String,
    var codigoPostal: String,
    var observaciones: String
   // @DrawableRes var foto: Int
) {

}
