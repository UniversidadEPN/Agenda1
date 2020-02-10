package com.epn.contactosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Principal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
    }

    fun onClicIngresar(view: View){
        val ingresar: Intent = Intent(this, IngresarContacto::class.java)
        startActivity(ingresar)
    }

    fun onClicModificar(view: View){
        val modificar: Intent = Intent(this,ModificarContacto::class.java)
        startActivity(modificar)
    }

    fun OnclicEliminar(view: View){
        val eliminar:Intent = Intent(this, EliminarContacto::class.java)
        startActivity(eliminar)
    }

    fun onClicConsultarId(view: View){
        val consultarId: Intent = Intent(this, ConsultarContactoId::class.java)
        startActivity(consultarId)
    }

    fun onClicConsultarTodos(view: View){
        val consultarTodos: Intent= Intent(this, ConsultarTodosContactos::class.java)
        startActivity(consultarTodos)
    }


}
