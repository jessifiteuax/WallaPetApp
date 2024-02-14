package com.wallapet.wallapetapp.data.repository

import com.wallapet.wallapetapp.data.network.MascotaDao
import com.wallapet.wallapetapp.domain.model.Mascota
import com.wallapet.wallapetapp.domain.repository.MascotaRepository

class MascotaRepositoryImpl(
    private val mascotaDao: MascotaDao
    ) : MascotaRepository {
    override fun getMascotas() = mascotaDao.getMascotas()
    override fun addMascota(mascota: Mascota) = mascotaDao.addMascota(mascota)
    override fun deleteMascota(mascota: Mascota) = mascotaDao.deleteMascota(mascota)
    override fun getMascota(id: Int): Mascota = mascotaDao.getMascota(id)
    override fun updateMascota(mascota: Mascota) = mascotaDao.updateMascota(mascota)
    }