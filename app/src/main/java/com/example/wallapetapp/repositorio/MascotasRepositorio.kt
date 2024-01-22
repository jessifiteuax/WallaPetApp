package com.example.wallapetapp.repositorio

import com.example.wallapetapp.model.Mascotas
import com.example.wallapetapp.room.MascotasBBDDDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject


class MascotasRepositorio @Inject constructor(private val mascotasBBDDDao: MascotasBBDDDao) {
    suspend fun addMascota(mascota: Mascotas) {
        mascotasBBDDDao.insert(mascota)
    }

    suspend fun updateMascota(mascota: Mascotas) {
        mascotasBBDDDao.update(mascota)
    }

    suspend fun deleteMascota(mascota: Mascotas) {
        mascotasBBDDDao.delete(mascota)
    }

    fun getMascotas(): Flow<List<Mascotas>> =
        mascotasBBDDDao.getMascotas().flowOn(Dispatchers.IO).conflate()

    fun getMascotasByPoblacion(poblacion: String): Flow<List<Mascotas>> =
        mascotasBBDDDao.getMascotasByPoblacion(poblacion).flowOn(Dispatchers.IO).conflate()

    fun getMascotasByCodigoPostal(codigoPostal: String): Flow<List<Mascotas>> =
        mascotasBBDDDao.getMascotasByCodigoPostal(codigoPostal).flowOn(Dispatchers.IO).conflate()
}