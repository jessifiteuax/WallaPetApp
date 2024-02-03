package com.example.wallapetapp.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallapetapp.domain.model.Mascota
import com.example.wallapetapp.domain.repository.MascotaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MascotasViewModel @Inject constructor(
    private val repo: MascotaRepository
) : ViewModel() {

    var mascota by mutableStateOf(Mascota(0,"", "","","","","", ""))
    val mascotas = repo.getMascotas()
    fun addMascota(mascota: Mascota) = viewModelScope.launch(Dispatchers.IO)
    {
        repo.addMascota(mascota)
    }
    fun deleteMascota(mascota: Mascota) = viewModelScope.launch(Dispatchers.IO)
    {
        repo.deleteMascota(mascota)
    }
    fun updateNombre(nombre:String) {
        mascota = mascota.copy(
            nombre = nombre
        )
    }
    fun updatePoblacion(poblacion:String) {
        mascota = mascota.copy(
            poblacion = poblacion
        )
    }
    fun updateCodPostal(codPostal:String) {
        mascota = mascota.copy(
            codPostal = codPostal
        )
    }
    fun updateMail(mail:String) {
        mascota = mascota.copy(
            mail = mail
        )
    }
    fun updateObservaciones(observaciones:String) {
        mascota = mascota.copy(
            observaciones = observaciones
        )
    }
    fun updateFecha(fecha:String) {
        mascota = mascota.copy(
            fecha = fecha
        )
    }
    fun updateFoto(foto:String) {
        mascota = mascota.copy(
            foto = foto
        )
    }
    fun updateMascota(mascota:Mascota)=viewModelScope.launch(Dispatchers.IO)
    {
        repo.updateMascota(mascota)
    }
    fun getMascota(id: Int) = viewModelScope.launch(Dispatchers.IO)
    {
        mascota = repo.getMascota(id)
    }

}