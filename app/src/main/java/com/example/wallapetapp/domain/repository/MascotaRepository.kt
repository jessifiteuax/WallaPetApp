package com.example.wallapetapp.domain.repository

import com.example.wallapetapp.domain.model.Mascota
import kotlinx.coroutines.flow.Flow

typealias Mascotas = List<Mascota>
interface MascotaRepository {
    fun getMascotas(): Flow<Mascotas>
    fun addMascota(mascota: Mascota)
    fun deleteMascota(mascota: Mascota)
    fun getMascota(id:Int): Mascota
    fun updateMascota(mascota: Mascota)

}