package com.epn.contactosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = DatabaseHandler(this)

        Log.d("Insert", "Inserting...")
        db.addContact(Contact("AAAX", "1233211232"))
        Log.d("Insert AAA", "Success!")
        db.addContact(Contact("BBB", "9143493981"))
        Log.d("Insert BBB", "Success!")

        Log.d("Reading:", "Reading all contacts...")
        val contacts = db.getAllContacts()
        for (cn in contacts) {
            val log = "Id: " + cn.id + " ,Name: " + cn.name + " ,Phone: " +
                    cn.phoneNumber
            Log.d("Name: ", log)
        }

        Log.d("Update:", "AAA->CCC")
        val contact1 = db.getContact(2)
        Log.d("Old Contact", contact1.name)
        contact1.name = "CCC"
        contact1.phoneNumber = "321321321"
        Log.d("New Contact", contact1.name)
        db.updateContact(contact1)


        Log.d("Deleting:", "Deleting all contacts...")
        for (c in contacts) {
            val log = "Id: " + c.id + " ,Name: " + c.name + " ,Phone: " +
                    c.phoneNumber
            Log.d("Delete: ", log)
            db.deleteContact(c)
        }
    }


}
