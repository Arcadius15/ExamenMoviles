package edu.pe.idat.app.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "paciente")
data class PacienteEntity (
    @PrimaryKey
    val codpaciente:Int,
    val password:String,
    val nombreapellido:String,
    val celular:String
)