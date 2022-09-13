package edu.pe.idat.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import edu.pe.idat.app.db.PacienteRoomDatabase
import edu.pe.idat.app.db.entity.PacienteEntity
import edu.pe.idat.app.repository.PacienteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PacienteViewModel (application: Application): AndroidViewModel(application){
    private val repository:PacienteRepository

    init{
        val pacienteDao = PacienteRoomDatabase.getDatabase(application).pacienteDao()
        repository = PacienteRepository(pacienteDao)
    }
    fun insertar(pacienteEntity: PacienteEntity) = viewModelScope.launch(Dispatchers.IO){
        repository.insertar(pacienteEntity)
    }

    fun actualizar(pacienteEntity: PacienteEntity) = viewModelScope.launch(Dispatchers.IO){
        repository.actualizar(pacienteEntity)
    }

    fun eliminartodo() = viewModelScope.launch(Dispatchers.IO){
        repository.eliminartodo()
    }

    fun obtener(): LiveData<PacienteEntity> {
        return repository.obtener()
    }
}