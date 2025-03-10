package com.example.inicio.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.inicio.R
import com.example.inicio.adapter.ContactAdapter
import com.example.inicio.data.DataSet
import com.example.inicio.databinding.ActivitySecondBinding
import com.example.inicio.model.User
import com.example.inicio.model.UserJSON
import com.example.inicio.ui.dialog.InfoDialog
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var userRecuperado : User
    private lateinit var adapterContact: ContactAdapter
    private lateinit var listaContact: ArrayList<UserJSON>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        instancias()
        crearPeticion()

        // recuperar el dato que me han pasado desde MainActivity a partir del intent (quien me ha arrancado)
        val bundleRecuperado = intent.extras?.getBundle("datos") // !! es cuando puedo garantizar que se pasan datos, se puede tambien ?
        // user - serializable as user
        userRecuperado = bundleRecuperado?.getSerializable("user") as User
        supportActionBar?.title = "Bienvenido ${userRecuperado.getCorreo()}"

    }

    private fun crearPeticion() {
        val gson: Gson = Gson()
        val url = "https://dummyjson.com/users"
        val peticionJSON: JsonObjectRequest =
            //JsonObjectRequest(url, Response.Listener { it }, Response.ErrorListener { it })
            JsonObjectRequest(url, {
                val users: JSONArray = it.getJSONArray("users")
                for(i in 0..users.length()-1){
                    val userJSON: JSONObject = users.getJSONObject(i)
                    val user: UserJSON = gson.fromJson(userJSON.toString(), UserJSON::class.java)
                    //Log.v("datos", user.getString("firstName")) // cuando userJSON era user
                    Log.v("datos", "El nombre del usuario es ${user.firstName} ${user.lastName}")
                    //listaContact.add(user)
                    adapterContact.addContact(user) // trabaja directo con la lista de ContactAdapter
                }
                //adapterContact.notifyDataSetChanged()
            }, {
                // Error
                Snackbar.make(binding.root, "Error en la peticion", Snackbar.LENGTH_SHORT).show()
            })
        Volley.newRequestQueue(applicationContext).add(peticionJSON)
    }

    private fun instancias() {
        listaContact = ArrayList()
        //adapterContact = ContactAdapter(DataSet.lista, this)
        adapterContact = ContactAdapter(listaContact, this)
        // asociar el adaptador con la lista de datos
        binding.recycler.adapter = adapterContact
        // si no hago este paso es imposible ver absolutamente nada

        if (resources.configuration.orientation == 1){ // caso Portrait mode
            binding.recycler.layoutManager = LinearLayoutManager(
                applicationContext, LinearLayoutManager.VERTICAL, false
            )
        } else {
            binding.recycler.layoutManager = GridLayoutManager(
                applicationContext,2, LinearLayoutManager.VERTICAL, false
            )
        }

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