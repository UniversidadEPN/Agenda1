package com.epn.contactosapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_eliminar_contacto.*


class EliminarContacto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eliminar_contacto)
    }


   fun onClicBuscar(view: View){

       val id:Int = editTextIDElimi_Elim.text.toString().toInt()

       val db= DatabaseHandler(this)
       val contacto= db.getContact(id)

       textViewIDCont_Elim.text =contacto.id.toString()
       textViewNomCont_Elim.text= contacto.name
       textViewTelCont_Elim.text= contacto.phoneNumber

       editTextIDElimi_Elim.setText("")
   }







    fun onClicEliminarContacto(view: View){

        val db= DatabaseHandler(this)
        val contacto= db.getContact(textViewIDCont_Elim.text.toString().toInt())


        val alerta = AlertDialog.Builder(this)

        alerta.setTitle(R.string.mensaje_advertencia_eliminar)
        alerta.setMessage(R.string.mensaje_advertencia_texto)
        alerta.setPositiveButton(R.string.mensaje_advertencia_si, { dialog: DialogInterface, i: Int ->
            Toast.makeText(this,R.string.mensaje_contacto_eliminado, Toast.LENGTH_LONG).show()
            db.deleteContact(contacto)

            editTextIDElimi_Elim.setText("")
            textViewIDCont_Elim.text =""
            textViewNomCont_Elim.text= ""
            textViewTelCont_Elim.text= ""

        })
        alerta.setNegativeButton(R.string.mensaje_advertencia_no, { dialog: DialogInterface?, i: Int ->  })
        alerta.show()


        /**/



        //finish()

    }
}
