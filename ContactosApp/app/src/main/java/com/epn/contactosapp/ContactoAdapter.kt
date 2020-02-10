package com.epn.contactosapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.todos_contactos.view.*


class ContactoAdapter(private val mContext: Context, private val listaContactos: List<Contact>): ArrayAdapter<Contact>(mContext, 0, listaContactos) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout= LayoutInflater.from(mContext).inflate(R.layout.todos_contactos, parent, false)

        val contacto= listaContactos[position]

        layout.textViewID.text = contacto.id.toString()
        layout.textViewNombreD.text = contacto.name
        layout.textViewNumD.text = contacto.phoneNumber
        layout.imageView7.setImageResource(R.drawable.usuario)

        return layout
    }

}