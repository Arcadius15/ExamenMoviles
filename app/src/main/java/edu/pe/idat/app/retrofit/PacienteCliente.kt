package edu.pe.idat.app.retrofit

import edu.pe.idat.app.utilitarios.Constantes
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object PacienteCliente {
    private var okHHTPClient = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.MINUTES)
        .writeTimeout(15, TimeUnit.MINUTES)
        .build()

    private fun buildRetrofit() = Retrofit.Builder().baseUrl(Constantes().API_JSON_PLACEHOLDER).client(
        okHHTPClient).addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService:PacienteServicio by lazy {
        buildRetrofit().create(PacienteServicio::class.java)
    }
}