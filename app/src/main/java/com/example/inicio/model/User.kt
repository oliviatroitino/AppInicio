package com.example.inicio.model

import java.io.Serializable

// constructores (primario -pedir datos obligatorios- y secundario), attr, function
class User(private var email: String?=null, private var password: String?=null, private var perfil: String?=null)
    : Serializable {

    // deberian tambien tener getters y setters
    private var direccion: String? = null
    private var telefono: Int? = null

    // Constructor Secundario
    constructor(correo: String?, pass: String?, perfil: String?, direccion: String?, telefono: Int?)
            : this(correo, pass, perfil){
                this.telefono = telefono
                this.direccion = direccion
            }

    // Getters y Setters
    fun getCorreo(): String? {
        return this.email
    }
    fun setCorreo(correo: String){
        this.email = correo
    }
    fun getPass(): String? {
        return this.password
    }
    fun setPass(pass: String){
        this.password = pass
    }
    fun getPerfil(): String? {
        return this.perfil
    }
    fun setPerfil(perfil: String){
        this.perfil = perfil
    }

}