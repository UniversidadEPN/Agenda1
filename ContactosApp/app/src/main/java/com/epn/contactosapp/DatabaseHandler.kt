package com.epn.contactosapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//class DatabaseHandler: SQLiteDatabase()

class DatabaseHandler (context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val createContactsTable = ("CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT" + ")")
        db.execSQL(createContactsTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_CONTACTS")
        onCreate(db)
    }


    fun addContact(contact: Contact) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(KEY_NAME, contact.name)
        values.put(KEY_PH_NO, contact.phoneNumber)

        db.insert(TABLE_CONTACTS, null, values)
        db.close()
    }
    //--------

    fun getContact(id: Int): Contact {
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_CONTACTS,
            arrayOf<String>(KEY_ID, KEY_NAME, KEY_PH_NO),
            KEY_ID + "=?",
            arrayOf(id.toString()),
            null,
            null,
            null,
            null
        )
        if (cursor != null) {
            cursor!!.moveToFirst()
        }
        return Contact(
            Integer.parseInt(cursor!!.getString(0)),
            cursor!!.getString(1), cursor!!.getString(2)
        )
    }



    fun getAllContacts(): List<Contact> {
        val contactList = ArrayList<Contact>()

        val sql_select = "SELECT * FROM $TABLE_CONTACTS"

        val db = this.writableDatabase
        val cursor = db.rawQuery(sql_select, null)

        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                val contact = Contact()
                contact.id= Integer.parseInt(cursor.getString(0))
                contact.name= cursor.getString(1)
                contact.phoneNumber= cursor.getString(2)
                contactList.add(contact)
            }
        }
        return contactList
    }


    fun updateContact(contact: Contact): Int {
        val db = this.writableDatabase

        val values = ContentValues().apply {
            put(KEY_NAME, contact.name)
            put(KEY_PH_NO, contact.phoneNumber)
        }
        return db.update(
            TABLE_CONTACTS, values, KEY_ID + "=?",
            arrayOf(contact.id.toString())
        )
    }


    fun deleteContact(contact: Contact) {
        val db = this.writableDatabase
        db.delete(
            TABLE_CONTACTS, KEY_ID + " =?",
            arrayOf(contact.id.toString())
        )
        db.close()
    }


    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "contactsManager"
        private const val TABLE_CONTACTS = "contacts"
        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
        private const val KEY_PH_NO = "phone_number"
    }


}