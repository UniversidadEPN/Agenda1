package com.epn.contactosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ingresar_contacto.*

class IngresarContacto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_contacto)

    }



    fun onClicIngresa(view: View){

        val nombre = editTextIngresarNom.text.toString()
        val telefono = editTextIngresarTel.text.toString()
        val db= DatabaseHandler(this)

        db.addContact(Contact(nombre, telefono ))
        editTextIngresarNom.setText("")
        editTextIngresarTel.setText("")

        Toast.makeText(this, R.string.mensaje_ingresar_contacto,Toast.LENGTH_LONG).show()


    }





}
