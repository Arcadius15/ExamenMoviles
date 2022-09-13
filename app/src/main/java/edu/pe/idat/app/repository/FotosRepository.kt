package edu.pe.idat.app.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import edu.pe.idat.app.retrofit.PacienteCliente
import edu.pe.idat.app.retrofit.response.JSONPlaceholder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FotosRepository {
    var responseFotos = MutableLiveData<List<JSONPlaceholder>>()

    fun listarFotos():MutableLiveData<List<JSONPlaceholder>>{
        val call: Call<List<JSONPlaceholder>> = PacienteCliente
            .retrofitService.listarMascota()
        call.enqueue(object : Callback<List<JSONPlaceholder>> {
            override fun onResponse(
                call: Call<List<JSONPlaceholder>>,
                response: Response<List<JSONPlaceholder>>
            )
            {
                responseFotos.value = response.body()
            }

            override fun onFailure(call: Call<List<JSONPlaceholder>>, t: Throwable) {
                Log.e("ErrorListarMascotas",t.message.toString())
            }

        })
        return responseFotos
    }

}