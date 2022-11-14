package com.app.news.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.news.R

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.NewsItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowItem = layoutInflater.inflate(R.layout.item_news, parent, false)
        return NewsItemViewHolder(rowItem)
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }

    class NewsItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    }
}