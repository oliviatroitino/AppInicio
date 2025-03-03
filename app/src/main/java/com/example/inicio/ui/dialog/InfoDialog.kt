package com.example.inicio.ui.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class InfoDialog : DialogFragment() {

    // primer metodo del ciclo de vida de una pantalla -> onCreate
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Información")
        builder.setMessage("App realizada para la asignatura de Desarrollo de Aplicaciones Móviles.")
        builder.setPositiveButton("OK"){ dialogInterface, i ->
            // accion al pulsar el boton positivo

        }

        return builder.create()
    }
}