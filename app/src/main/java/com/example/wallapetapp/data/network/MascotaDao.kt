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

    @Query("SELECT * FROM mascotasTable WHERE codPostal= :codPostal ORDER BY fecha ASC")
    fun getMascotasByCodpostal(codPostal:String): Flow<Mascotas>
    @Query("SELECT * FROM mascotasTable WHERE poblacion= :poblacion ORDER BY fecha ASC")
    fun getMascotasByPoblacion(poblacion:String): Flow<Mascotas>

    @Insert(onConflict = IGNORE)
    fun addMascota(mascota: Mascota)

    //getMascota
    //updateMascota
    //deleteMascota
}