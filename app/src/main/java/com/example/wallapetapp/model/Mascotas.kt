package com.example.wallapetapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mascotas")
data class Mascotas(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "Nombre")
    val nombre: String = "Desconocido",
    @ColumnInfo(name = "Población")
    val poblacion: String,
    @ColumnInfo(name = "Código Postal")
    val codigoPostal: String,
    @ColumnInfo(name = "email")
    val mail: String,
    @ColumnInfo(name="Observaciones")
    val observaciones: String = "Desconocido"
   // @DrawableRes var foto: Int

) {

}
