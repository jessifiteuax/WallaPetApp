package com.example.wallapetapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.wallapetapp.model.Mascotas
import kotlinx.coroutines.flow.Flow

@Dao
interface MascotasBBDDDao {

    @Query("SELECT * FROM mascotas")
    fun getMascotas(): Flow<List<Mascotas>>

    @Query("SELECT * FROM mascotas WHERE poblacion = :poblacion")
    fun getMascotasByPoblacion(poblacion: String): Flow<List<Mascotas>>

    @Query("SELECT * FROM mascotas WHERE codigopostal = :codigoPostal")
    fun getMascotasByCodigoPostal(codigoPostal: String): Flow<List<Mascotas>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mascota:Mascotas)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(mascota:Mascotas)

    @Delete
    suspend fun delete(mascota: Mascotas)

}