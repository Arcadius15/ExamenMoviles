package edu.pe.idat.app.utilitarios

import edu.pe.idat.app.db.entity.PacienteEntity

class Constantes {
    val API_JSON_PLACEHOLDER = "https://jsonplaceholder.typicode.com/"

    val usuarios:ArrayList<PacienteEntity> = arrayListOf(
        PacienteEntity(1,"a","a","1196"),
        PacienteEntity(2,"b","b","1196"),
        PacienteEntity(3,"c","c","1196")
    )
}