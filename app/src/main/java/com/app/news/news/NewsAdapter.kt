package com.app.news.news

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.app.news.R
import com.app.news.response.NewsList
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(val context: Context, val newsList: NewsList) : RecyclerView.Adapter<NewsAdapter.NewsItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowItem = layoutInflater.inflate(R.layout.item_news, parent, false)
        return NewsItemViewHolder(rowItem)
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.view.txtTitle.text = newsList.articles.get(position).title
        holder.view.txtDescription.text = newsList.articles.get(position).description
        holder.view.newsItemContainer.setOnClickListener {
            // open chrome custom tab here
            val url = newsList.articles.get(position).url

            val builder = CustomTabsIntent.Builder()
            builder.setShowTitle(true)
            val customTabsIntent : CustomTabsIntent = builder.build()
            customTabsIntent.launchUrl(context, Uri.parse(url))
        }
    }

    override fun getItemCount(): Int {
//        return newsList.totalResults
        return 50
    }

    class NewsItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    }
}