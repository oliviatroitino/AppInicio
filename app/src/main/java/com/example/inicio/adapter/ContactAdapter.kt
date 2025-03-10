package com.example.inicio.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.inicio.R
import com.example.inicio.model.Contact
import com.example.inicio.model.UserJSON
import com.example.inicio.ui.activity.ContactActivity
import com.example.inicio.ui.activity.SecondActivity

//class ContactAdapter(var lista: List<Contact>, var context: Context) :
class ContactAdapter(var lista: List<UserJSON>, var context: Context) :
    RecyclerView.Adapter<ContactAdapter.MyHolder>() {

    inner class MyHolder(itemView: View) : ViewHolder(itemView) {
        // representa el patron con la extraccion de cada uno de los elementos del XML
        val imagen = itemView.findViewById<ImageView>(R.id.imagenCard)
        val texto : TextView = itemView.findViewById(R.id.phoneCard)
        val toolbar : Toolbar = itemView.findViewById(R.id.toolbarCard)
        val card : CardView = itemView.findViewById(R.id.cardContact)

        // asociar un menu a cada carta
        init {
            toolbar.inflateMenu(R.menu.contact_menu)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // retornar una clase anidada con la estructura del patron
        val vista: View = LayoutInflater.from(context).inflate(
            R.layout.recycler_item, parent, false
        )
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        // cuantos elementos se pintaran (filas)
        return this.lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) { // adaptado a UserJSON
        // con el patron y la posicion dada, asociar el patron con los datos
        // ejecutado tantas veces como getItemCount()
        val contact = lista[position] // recomendable sobre lista.get(position)
        holder.toolbar.setOnMenuItemClickListener {
            // si le das a x haces y
//            when(it.itemId){
//                R.id.menuContactLlamar->{}
//            }
            return@setOnMenuItemClickListener false; // asi hace el return de setOnMenu... en vez de onBindViewHolder
        }
        //holder.toolbar.title = contact.nombre
        holder.toolbar.title = contact.firstName + " " + contact.lastName
        //holder.texto.text = contact.telefono.toString()
        holder.texto.text = contact.phone.toString()
        //Glide.with(context).load(contact.imagen)
        Glide.with(context).load(contact.image)
            .placeholder(R.drawable.defaultcontact)
            .into(holder.imagen)
        holder.card.setOnClickListener{
//            val intent = Intent(SecondActivity::class.java, ContactActivity::class.java) // TODO completar origen y destino
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            context.startActivity(intent)
        }
    }

    fun addContact(contact: UserJSON){
        (lista as ArrayList).add(contact)
        notifyItemInserted(lista.size-1)
    }

}
