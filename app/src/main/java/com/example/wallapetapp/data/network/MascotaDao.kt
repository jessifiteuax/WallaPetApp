package com.example.wallapetapp.data.network

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.wallapetapp.domain.model.Mascota
import com.example.wallapetapp.domain.repository.Mascotas
import kotlinx.coroutines.flow.Flow

@Dao
interface MascotaDao {
    @Query("SELECT * FROM mascotasTable ORDER BY fecha ASC")
    fun getMascotas(): Flow<Mascotas>

    @Insert(onConflict = IGNORE)
    fun addMascota(mascota: Mascota)

    //getMascota
    //updateMascota
    //deleteMascota
}