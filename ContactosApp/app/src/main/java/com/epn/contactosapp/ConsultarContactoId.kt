package com.epn.contactosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_consultar_contacto_id.*

class ConsultarContactoId : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_contacto_id)
    }

    fun onClicBuscar(view: View){



        val id:Int = editTextBuscarId_ConsultaID.text.toString().toInt()

        val db= DatabaseHandler(this)
        val contacto= db.getContact(id)


        textViewIdContact.text =contacto.id.toString()
        textViewNombreContac.text= contacto.name
        textViewTelefonoContact.text= contacto.phoneNumber.toString()

        editTextBuscarId_ConsultaID.setText("")

    }


}
