package com.example.wallapetapp.vm

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
): ViewModel() {
    val mascotas = repo.getMascotas()
    fun addMascota(mascota: Mascota)= viewModelScope.launch(Dispatchers.IO)
    {
        repo.addMascota(mascota)
    }
}