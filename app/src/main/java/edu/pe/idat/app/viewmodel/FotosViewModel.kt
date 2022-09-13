package edu.pe.idat.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import edu.pe.idat.app.repository.FotosRepository
import edu.pe.idat.app.retrofit.response.JSONPlaceholder

class FotosViewModel :ViewModel(){
    private var repository = FotosRepository()

    fun listarFotos():LiveData<List<JSONPlaceholder>>{
        return repository.listarFotos()
    }

}