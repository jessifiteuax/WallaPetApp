package com.wallapet.wallapetapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "mascotasTable")
data class Mascota(
    @PrimaryKey (autoGenerate = true)
    val id:Int,
    val nombre:String,
    val poblacion: String,
    val codPostal: String,
    val mail: String,
    val observaciones: String,
    val fecha: String,
    val foto: String
)
