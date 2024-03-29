package com.example.wallapetapp.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wallapetapp.domain.model.Mascota

@Database(entities = [Mascota::class], version = 2, exportSchema = false)
abstract class MascotaDB : RoomDatabase() {
    abstract fun mascotaDao(): MascotaDao
}