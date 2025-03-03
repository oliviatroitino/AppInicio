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

class ContactAdapter(var lista: List<Contact>, var context: Context) :
    RecyclerView.Adapter<ContactAdapter.MyHolder>() {

    inner class MyHolder(itemView: View) : ViewHolder(itemView) {
        // representa el patron con la extraccion de cada uno de los elementos del XML
        val imagen = itemView.findViewById<ImageView>(R.id.imagenCard)
        val texto : TextView = itemView.findViewById(R.id.phoneCard)
        val toolbar : Toolbar = itemView.findViewById(R.id.toolbarCard)
        val card : CardView = itemView.findViewById(R.id.cardContact)

        // TODO asociar un menu a cada carta
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

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // con el patron y la posicion dada, asociar el patron con los datos
        // ejecutado tantas veces como getItemCount()
        val contact = lista[position] // recomendable sobre lista.get(position)
        holder.toolbar.title = contact.nombre
        holder.texto.text = contact.telefono.toString()
        Glide.with(context).load(contact.imagen)
            .placeholder(R.drawable.defaultcontact)
            .into(holder.imagen)
        holder.card.setOnClickListener{
            val intent: Intent() // TODO completar
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
}