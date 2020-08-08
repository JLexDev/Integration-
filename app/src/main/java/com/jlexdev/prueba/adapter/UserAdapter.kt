package com.jlexdev.prueba.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jlexdev.prueba.R
import com.jlexdev.prueba.models.UserResponse

/**
 * Created by JLex on 7/16/20
 */
class UserAdapter (var list: List<UserResponse>) : RecyclerView.Adapter<UserViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_user,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item: UserResponse = list[position]
        holder.tvName.text = item.name
        holder.tvJob.text = item.job
    }

}