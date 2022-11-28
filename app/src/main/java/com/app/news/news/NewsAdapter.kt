package com.app.news.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.app.news.R
import com.app.news.newsDetail.NewsDetailFragment
import com.app.news.response.NewsList
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(val newsList: NewsList) : RecyclerView.Adapter<NewsAdapter.NewsItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowItem = layoutInflater.inflate(R.layout.item_news, parent, false)
        return NewsItemViewHolder(rowItem)
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.view.txtTitle.text = newsList.articles.get(position).title
        holder.view.txtDescription.text = newsList.articles.get(position).description
        holder.view.newsItemContainer.setOnClickListener {
            // start the detail fragment here
            val bundle = Bundle()
            bundle.putString("url", newsList.articles.get(position).url)

            val activity = it.context as AppCompatActivity
            val newsDetailFragment = NewsDetailFragment()
            activity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.flyt_container_body, newsDetailFragment.javaClass, bundle, null)
                .commitNow()
        }
    }

    override fun getItemCount(): Int {
//        return newsList.totalResults
        return 50
    }

    class NewsItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    }
}