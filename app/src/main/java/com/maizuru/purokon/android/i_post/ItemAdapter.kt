package com.maizuru.purokon.android.i_post

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val list: List<String>): RecyclerView.Adapter<ViewHolderList>() {
    override fun getItemViewType(position: Int): Int {
        return if(position == 0 || position == 4) 0 else 1
    }

    val images: ArrayList<Int> = arrayListOf(
        R.drawable.icon,
        R.drawable.logo,
    )

    class textViewHolder(view: View): ViewHolderList(view) {
        val textView: TextView
        init {
            textView = view.findViewById(R.id.Text1)
        }
    }

    class imageViewHolder(view: View): ViewHolderList(view) {
        val imageView: ImageView
        init {
            imageView = view.findViewById(R.id.image_view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): ViewHolderList {
        if (viewType == 0){
            val imageView = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_imagelist, parent, false)
            return imageViewHolder(imageView)
        } else {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_textlist, parent, false)
            return textViewHolder(itemView)
        }
    }

    override fun onBindViewHolder(holder: ViewHolderList, position: Int) {
        if (position == 0 || position == 4) {
            holder.characterList.text = list[position]
        } else {
            val imageViewHolder = holder as imageViewHolder
            imageViewHolder.imageView.setImageResource(images.get(position))
        }
    }
    override fun getItemCount(): Int = list.size
}

class MyAdapter(private val myDataset: Array<String>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val VIEW_TYPE_ONE = 1
    private val VIEW_TYPE_TWO = 2

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) {
            VIEW_TYPE_ONE
        } else {
            VIEW_TYPE_TWO
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = when (viewType) {
            VIEW_TYPE_ONE -> LayoutInflater.from(parent.context)
                .inflate(R.layout.my_layout_one, parent, false)
            else -> LayoutInflater.from(parent.context)
                .inflate(R.layout.my_layout_two, parent, false)
        }
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = myDataset[position]
    }

    override fun getItemCount() = myDataset.size

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
    }
}








