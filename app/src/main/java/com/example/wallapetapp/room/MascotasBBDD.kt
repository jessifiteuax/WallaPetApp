package com.example.wallapetapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wallapetapp.model.Mascotas

//si hay mas de una tabla se ponen seguidas de ésta (Mascotas)
@Database(entities = [Mascotas::class], version = 3, exportSchema = false)
abstract class MascotasBBDD: RoomDatabase() {
    abstract fun mascotasDao(): MascotasBBDDDao

}