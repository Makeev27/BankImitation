package com.example.bankimitation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bankimitation.R
import com.example.bankimitation.classes.Card

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var cards: List<Card> = mutableListOf()


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

    override fun getItemCount() = cards.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}