package com.example.wallapetapp.data.repository

import com.example.wallapetapp.data.network.MascotaDao
import com.example.wallapetapp.domain.model.Mascota
import com.example.wallapetapp.domain.repository.MascotaRepository
import com.example.wallapetapp.domain.repository.Mascotas
import kotlinx.coroutines.flow.Flow

class MascotaRepositoryImpl(
    private val mascotaDao: MascotaDao
    ) : MascotaRepository {
    override fun getMascotas() = mascotaDao.getMascotas()
    override fun addMascota(mascota: Mascota) = mascotaDao.addMascota(mascota)
    //getMascotas
    //updateMascotas
    //deleteMascotas
    }