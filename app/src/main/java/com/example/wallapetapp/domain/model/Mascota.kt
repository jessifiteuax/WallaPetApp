package com.example.wallapetapp.domain.model

import android.graphics.Picture
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

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
