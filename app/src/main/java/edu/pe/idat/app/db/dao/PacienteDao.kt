package edu.pe.idat.app.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import edu.pe.idat.app.db.entity.PacienteEntity

@Dao
interface PacienteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertar(vararg paciente:PacienteEntity)

    @Update
    fun actualizar(vararg paciente:PacienteEntity)

    @Query("DELETE FROM paciente")
    fun eliminarTodo()

    @Query("SELECT * FROM paciente LIMIT 1")
    fun obtener(): LiveData<PacienteEntity>
}