package com.example.contactmanager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var contactRecyclerView: RecyclerView
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DBHelper(this)
        contactRecyclerView = findViewById(R.id.contactRecyclerView)
        contactRecyclerView.layoutManager = LinearLayoutManager(this)
        contactAdapter = ContactAdapter(this, dbHelper.fetchAllContacts())
        contactRecyclerView.adapter = contactAdapter

        findViewById<View>(R.id.btnAddContact).setOnClickListener {
            startActivity(Intent(this, AddContactActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        contactAdapter.updateContacts(dbHelper.fetchAllContacts())
    }
}
