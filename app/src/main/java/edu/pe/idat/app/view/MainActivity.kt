package edu.pe.idat.app.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import edu.pe.idat.app.R
import edu.pe.idat.app.databinding.ActivityMainBinding
import edu.pe.idat.app.db.entity.PacienteEntity
import edu.pe.idat.app.utilitarios.AppMensaje
import edu.pe.idat.app.utilitarios.Constantes
import edu.pe.idat.app.utilitarios.TipoMensaje
import edu.pe.idat.app.viewmodel.PacienteViewModel

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pacienteViewModel: PacienteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pacienteViewModel = ViewModelProvider(this)
            .get(PacienteViewModel::class.java)
        pacienteViewModel.eliminartodo()
        binding.btnlogin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnlogin->autenticarUsuario()
        }
    }

    private fun autenticarUsuario() {
        var okLogin = true
        if (binding.etusuario.text.toString().trim().isEmpty()){
            binding.etusuario.isFocusableInTouchMode = true
            binding.etusuario.requestFocus()
            okLogin = false
        }else if (binding.etpassword.text.toString().trim().isEmpty()) {
            binding.etpassword.isFocusableInTouchMode = true
            binding.etpassword.requestFocus()
            okLogin = false
        }
        if (okLogin){
            validaUsuario()
        }else{
            AppMensaje.enviarMensaje(binding.root,"Ingrese su Usuario o Password", TipoMensaje.ERROR)
        }
    }

    private fun validaUsuario(){
        val user = binding.etusuario.text.toString().toInt()
        val psw = binding.etpassword.text.toString()
        val usuarios:ArrayList<PacienteEntity> = Constantes().usuarios
        usuarios.forEach {
            if (it.codpaciente.equals(user)&& it.password.equals(psw)){
                AppMensaje.enviarMensaje(binding.root,"Logeado", TipoMensaje.EXITO)
                pacienteViewModel.insertar(it)
                startActivity(Intent(applicationContext,HomeActivity::class.java))
                finish()
            }
        }
        AppMensaje.enviarMensaje(binding.root,"Error", TipoMensaje.ERROR)
    }
}