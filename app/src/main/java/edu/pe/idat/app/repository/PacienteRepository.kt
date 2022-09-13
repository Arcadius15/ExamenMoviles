package edu.pe.idat.app.repository

import androidx.lifecycle.LiveData
import edu.pe.idat.app.db.dao.PacienteDao
import edu.pe.idat.app.db.entity.PacienteEntity

class PacienteRepository (private val pacienteDao: PacienteDao){
    suspend fun insertar(pacienteEntity: PacienteEntity){
        pacienteDao.insertar(pacienteEntity)
    }

    suspend fun actualizar(pacienteEntity: PacienteEntity){
        pacienteDao.actualizar(pacienteEntity)
    }

    suspend fun eliminartodo(){
        pacienteDao.eliminarTodo()
    }

    fun obtener(): LiveData<PacienteEntity> {
        return pacienteDao.obtener()
    }
}