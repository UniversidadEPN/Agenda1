package com.epn.contactosapp


import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_consultar_todos_contactos.*
import androidx.appcompat.app.AlertDialog



class ConsultarTodosContactos : AppCompatActivity() {


    private lateinit var listView: ListView
    private lateinit var listViewItems: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_todos_contactos)

        listView = findViewById<ListView>(R.id.listaContactos)
        listViewItems = ArrayList<String>(100)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listViewItems)
        listView.adapter = adapter

        val db = DatabaseHandler(this)
        val contactos = db.getAllContacts()

        val contacto= db.getContact(1)


        val listaDeContactos2 = ArrayList( listOf<Contact>())

        (listaDeContactos2 as MutableCollection<Contact>).add(contacto)
        for(c in contactos) {
            (listaDeContactos2 as MutableCollection<Contact>).add(c)
        }



        val adapter = ContactoAdapter(this, listaDeContactos2)
        listaContactos.adapter = adapter




        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                //CONTACTOS
                val contacto = db.getContact(position+1)
                val alerta = AlertDialog.Builder(this)

                alerta.setTitle(contacto.name)
                alerta.setMessage(contacto.phoneNumber)
                alerta.setPositiveButton("Llamar", { dialog: DialogInterface, i: Int ->
                    /***
                     * Programar para hacer llamada
                     */


                })
                alerta.setNegativeButton("Salir", { dialog: DialogInterface?, i: Int ->  })
                alerta.show()


            }


    }


}



/*

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class ConsultarTodosContactos : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var listViewItems: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_todos_contactos)

        listView = findViewById<ListView>(R.id.ListViewCont)
        listViewItems = ArrayList<String>(100)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listViewItems)
        listView.adapter = adapter

        val db = DatabaseHandler(this)
        val contactos = db.getAllContacts()
        val contacto= db.getContact(1)


        adapter.add(contacto.name)
        for(c in contactos){
           adapter.add(c.name)
        }



        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
               //CONTACTOS
                val contacto = db.getContact(position+1)
                val alerta = AlertDialog.Builder(this)

                alerta.setTitle(contacto.name)
                alerta.setMessage(contacto.phoneNumber)
                alerta.setPositiveButton("Llamar", { dialog: DialogInterface, i: Int ->
                    /***
                     * Programar para hacer llamada
                     */


                })
                alerta.setNegativeButton("Salir", { dialog: DialogInterface?, i: Int ->  })
                alerta.show()


            }




    }


}
 */
