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
    @ColumnInfo(name = "Poblacion")
    val poblacion: String,
    @ColumnInfo(name = "CodigoPostal")
    val codigopostal: String,
    @ColumnInfo(name = "email")
    val mail: String,
    @ColumnInfo(name="Observaciones")
    val observaciones: String = "Desconocido",
    @ColumnInfo(name="idUsuario")
    val idusuario: Int
   // @DrawableRes var foto: Int

)
