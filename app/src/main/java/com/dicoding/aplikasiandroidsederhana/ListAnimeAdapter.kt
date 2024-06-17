package com.dicoding.aplikasiandroidsederhana

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListAnimeAdapter( private val listAnime: ArrayList<Anime>) : RecyclerView.Adapter<ListAnimeAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_anime, parent, false)
        return ListViewHolder(view)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, description, image) = listAnime[position]
        holder.imgPhoto.setImageResource(image)
        holder.tvTitle.text = title
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener{
            val intentDetailAnime = Intent(holder.itemView.context, DetailAnime::class.java)
            intentDetailAnime.putExtra("key_anime", listAnime[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetailAnime)

        }
    }

    override fun getItemCount(): Int  = listAnime.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_image)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Anime)
    }

}
