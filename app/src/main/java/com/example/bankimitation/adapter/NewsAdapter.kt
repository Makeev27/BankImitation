package com.example.bankimitation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bankimitation.R
import com.example.bankimitation.classes.Card

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    var data: List<Card> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardImageView: ImageView = itemView.findViewById(R.id.cardImageView)
        val cardTextView: TextView = itemView.findViewById(R.id.cardTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(itemView)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val card = data[position]
        val context = holder.itemView.context

        with(holder.itemView) {
            holder.cardTextView.text = card.text
            Glide.with(context).load(card.photo).centerCrop().error(R.color.white)
                .placeholder(R.color.grey).into(holder.cardImageView)

        }
    }
}