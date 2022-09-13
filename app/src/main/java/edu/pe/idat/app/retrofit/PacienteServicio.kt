package edu.pe.idat.app.retrofit

import edu.pe.idat.app.retrofit.response.JSONPlaceholder
import retrofit2.Call
import retrofit2.http.GET

interface PacienteServicio {
    @GET("photos")
    fun listarMascota(): Call<List<JSONPlaceholder>>
}