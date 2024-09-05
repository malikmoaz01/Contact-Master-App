package com.example.contactmanager

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class UpdateContactActivity : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper
    private var contactId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_contact)

        dbHelper = DBHelper(this)
        val etName = findViewById<EditText>(R.id.etName)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val btnUpdate = findViewById<Button>(R.id.btnUpdate)

        contactId = intent.getIntExtra("contactId", -1)
        val contact = dbHelper.fetchContact(contactId)

        if (contact != null) {
            etName.setText(contact.name)
            etPhone.setText(contact.phone)
        }

        btnUpdate.setOnClickListener {
            val name = etName.text.toString()
            val phone = etPhone.text.toString()
            dbHelper.updateContact(Contact(contactId, name, phone))
            finish()
        }
    }
}
