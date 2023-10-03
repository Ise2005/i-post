package com.maizuru.purokon.android.i_post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val list: List<String>) : RecyclerView.Adapter<ViewHolderList>() {
    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): ViewHolderList {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_list, parent, false)
        return ViewHolderList(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderList, position: Int) {
        holder.characterList.text = list[position]
    }

    override fun getItemCount(): Int = list.size
}