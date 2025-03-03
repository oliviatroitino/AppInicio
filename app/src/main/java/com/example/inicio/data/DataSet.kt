package com.example.inicio.data

import com.example.inicio.model.Contact

class DataSet {

    // JAVA: static List<Contact> lista = new ArrayList()
    companion object{
        val lista: List<Contact> = arrayListOf(
            Contact("Contacto1", 123123, "Las rozas", ""),
            Contact("Contacto2", 123456, "Pozuelo", ""),
            Contact("Contacto3", 456789, "Majadahonda", ""),
            Contact("Contacto4", 123789, "Madrid", ""),
            Contact("Contacto5", 634561, "Las Matas", "")
        )
    }

}