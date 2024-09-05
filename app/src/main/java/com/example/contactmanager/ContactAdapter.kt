package com.example.contactmanager

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private val context: Context, private var contacts: List<Contact>) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.nameTextView.text = contact.name
        holder.phoneTextView.text = contact.phone
        holder.itemView.setOnClickListener {
            val intent = Intent(context, UpdateContactActivity::class.java)
            intent.putExtra("CONTACT_ID", contact.id)
            intent.putExtra("CONTACT_NAME", contact.name)
            intent.putExtra("CONTACT_PHONE", contact.phone)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    fun updateContacts(newContacts: List<Contact>) {
        contacts = newContacts
        notifyDataSetChanged()
    }

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.tvName)
        val phoneTextView: TextView = itemView.findViewById(R.id.tvPhone)
    }
}
