package com.example.saveuserapp.ui.users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.saveuserapp.R
import com.example.saveuserapp.data.local.entity.User

class UsersListAdapter(private val it: List<User>) :
    RecyclerView.Adapter<UsersListAdapter.MyHolder>() {

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tv_name)
        val address: TextView = itemView.findViewById(R.id.tv_address)
        val phone: TextView = itemView.findViewById(R.id.tv_phone)
        val email: TextView = itemView.findViewById(R.id.tv_email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)

        return MyHolder(view)
    }

    override fun getItemCount(): Int = it.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val sortedAppsList = it.sortedBy { it.name }
        holder.name.text = sortedAppsList[position].name
        holder.address.text = sortedAppsList[position].address
        holder.phone.text = sortedAppsList[position].phone
        holder.email.text = sortedAppsList[position].email
    }
}