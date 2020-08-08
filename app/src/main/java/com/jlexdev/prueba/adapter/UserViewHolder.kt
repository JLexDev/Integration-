package com.jlexdev.prueba.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jlexdev.prueba.R

/**
 * Created by JLex on 7/16/20
 */
class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    // Name & Job
    var tvName: TextView = itemView.findViewById(R.id.tv_name)
    var tvJob: TextView = itemView.findViewById(R.id.tv_job)

}