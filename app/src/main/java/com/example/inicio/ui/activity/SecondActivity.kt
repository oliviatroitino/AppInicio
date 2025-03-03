package com.example.inicio.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inicio.R
import com.example.inicio.adapter.ContactAdapter
import com.example.inicio.data.DataSet
import com.example.inicio.databinding.ActivitySecondBinding
import com.example.inicio.model.User
import com.example.inicio.ui.dialog.InfoDialog

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var userRecuperado : User
    private lateinit var adapterContact: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        instancias()

        // recuperar el dato que me han pasado desde MainActivity a partir del intent (quien me ha arrancado)
        val bundleRecuperado = intent.extras?.getBundle("datos") // !! es cuando puedo garantizar que se pasan datos, se puede tambien ?
        // user - serializable as user
        userRecuperado = bundleRecuperado?.getSerializable("user") as User
        supportActionBar?.title = "Bienvenido ${userRecuperado.getCorreo()}"

    }

    private fun instancias() {
        adapterContact = ContactAdapter(DataSet.lista, this)
        // asociar el adaptador con la lista de datos
        binding.recycler.adapter = adapterContact
        // si no hago este paso es imposible ver absolutamente nada
        binding.recycler.layoutManager = LinearLayoutManager(
            applicationContext, LinearLayoutManager.VERTICAL, false
        )

    }

    override fun onStart() {
        super.onStart()
        // quiero acceder a los datos del usuario
        Log.v("datos", userRecuperado.getCorreo()?:"Sin correo")
        Log.v("datos", userRecuperado.getPerfil()?:"Sin perfil")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
                                    // item clicked
        when(item.itemId){
            R.id.menuCerrarSesion ->{
                // para volver a la pantalla anterior (destruir la de ahora)
                finish()
            }
            R.id.menuInfo ->{
                val dialogo = InfoDialog()
                dialogo.show(supportFragmentManager, null)
            }
            R.id.menuSub1 ->{}
            R.id.menuSub2 ->{}
        }
        return true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}