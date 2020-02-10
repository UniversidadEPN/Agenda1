package com.epn.contactosapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_consultar_contacto_id.*
import kotlinx.android.synthetic.main.activity_modificar_contacto.*

class ModificarContacto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar_contacto)
        editTextNomCont_Modi.setEnabled(false)
        editTextTelCont_Modi.setEnabled(false)
    }


    fun onClicBuscar(view: View){

        val id:Int = editTextIdCont_Modifi.text.toString().toInt()

        val db= DatabaseHandler(this)
        val contacto= db.getContact(id)

        editTextiDCont_Modi.setText(contacto.id.toString())
        editTextNomCont_Modi.setText((contacto.name))
        editTextTelCont_Modi.setText((contacto.phoneNumber))

        editTextNomCont_Modi.setEnabled(true)
        editTextTelCont_Modi.setEnabled(true)
        editTextIdCont_Modifi.setText("")

    }


    fun clicOnModificarContacto(view: View) {

        val db= DatabaseHandler(this)
        val contacto = db.getContact(editTextiDCont_Modi.text.toString().toInt())


        contacto.name = editTextNomCont_Modi.text.toString()
        contacto.phoneNumber = editTextTelCont_Modi.text.toString()

        db.updateContact(contacto)

        editTextiDCont_Modi.setText("")
        editTextNomCont_Modi.setText("")
        editTextTelCont_Modi.setText("")






        Toast.makeText(this, R.string.mensaje_contacto_modificado , Toast.LENGTH_LONG).show()
    }


}
