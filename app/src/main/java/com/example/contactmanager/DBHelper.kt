package com.example.contactmanager

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "ContactManager"
        private const val TABLE_NAME = "Contacts"
        private const val ID_COL = "_id"
        private const val NAME_COL = "Name"
        private const val PHONE_COL = "Phone"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = ("CREATE TABLE " + TABLE_NAME + "("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NAME_COL + " TEXT NOT NULL,"
                + PHONE_COL + " TEXT NOT NULL" + ")")
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addContact(contact: Contact): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME_COL, contact.name)
        values.put(PHONE_COL, contact.phone)
        return db.insert(TABLE_NAME, null, values)
    }

    fun updateContact(contact: Contact): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME_COL, contact.name)
        values.put(PHONE_COL, contact.phone)
        return db.update(TABLE_NAME, values, "$ID_COL=?", arrayOf(contact.id.toString()))
    }

    fun deleteContact(id: Int): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_NAME, "$ID_COL=?", arrayOf(id.toString()))
    }

    fun fetchContact(id: Int): Contact? {
        val db = this.readableDatabase
        val cursor: Cursor = db.query(
            TABLE_NAME,
            null,
            "$ID_COL=?",
            arrayOf(id.toString()),
            null,
            null,
            null
        )
        var contact: Contact? = null
        if (cursor.moveToFirst()) {
            val name = cursor.getString(cursor.getColumnIndexOrThrow(NAME_COL))
            val phone = cursor.getString(cursor.getColumnIndexOrThrow(PHONE_COL))
            contact = Contact(id, name, phone)
        }
        cursor.close()
        return contact
    }

    fun fetchAllContacts(): List<Contact> {
        val db = this.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        val contacts = mutableListOf<Contact>()
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow(ID_COL))
                val name = cursor.getString(cursor.getColumnIndexOrThrow(NAME_COL))
                val phone = cursor.getString(cursor.getColumnIndexOrThrow(PHONE_COL))
                contacts.add(Contact(id, name, phone))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return contacts
    }
}
