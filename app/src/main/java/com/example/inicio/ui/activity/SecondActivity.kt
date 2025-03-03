package com.example.inicio

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.databinding.ActivitySecondBinding
import com.example.inicio.model.User

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var userRecuperado : User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        // recuperar el dato que me han pasado desde MainActivity a partir del intent (quien me ha arrancado)
        val bundleRecuperado = intent.extras?.getBundle("datos") // !! es cuando puedo garantizar que se pasan datos, se puede tambien ?
        // user - serializable as user
        userRecuperado = bundleRecuperado?.getSerializable("user") as User
        binding.textoUsuario.text = "Bienvenido ${userRecuperado.getCorreo()}"

    }

    override fun onStart() {
        super.onStart()
        // quiero acceder a los datos del usuario
        Log.v("datos", userRecuperado.getCorreo()?:"Sin correo")
        Log.v("datos", userRecuperado.getPerfil()?:"Sin perfil")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}