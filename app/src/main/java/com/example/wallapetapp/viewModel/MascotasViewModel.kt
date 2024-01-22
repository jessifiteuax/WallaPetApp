package com.example.wallapetapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallapetapp.model.Mascotas
import com.example.wallapetapp.repositorio.MascotasRepositorio
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MascotasViewModel @Inject constructor(private val repositorio: MascotasRepositorio): ViewModel() {
    private val _mascotasList = MutableStateFlow<List<Mascotas>>(emptyList())
    val mascotasList = _mascotasList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repositorio.getMascotas().collect { item ->
                if(item.isNotEmpty()){
                    _mascotasList.value = emptyList()
                }else{
                    _mascotasList.value = item
                }
            }
        }
    }
    fun addMascota (mascota:Mascotas) = viewModelScope.launch { repositorio.addMascota(mascota) }
    fun updateMascota (mascota:Mascotas) = viewModelScope.launch { repositorio.updateMascota(mascota) }
    fun delteMascota (mascota:Mascotas) = viewModelScope.launch { repositorio.deleteMascota(mascota) }

}