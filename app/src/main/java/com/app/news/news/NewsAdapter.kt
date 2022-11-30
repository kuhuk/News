package com.app.news.news

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.app.news.R
import com.app.news.response.Articles
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(private val context: Context) : RecyclerView.Adapter<NewsAdapter.NewsItemViewHolder>() {

    private var articles = ArrayList<Articles>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowItem = layoutInflater.inflate(R.layout.item_news, parent, false)
        return NewsItemViewHolder(rowItem)
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        if (articles.size > 0) {
            holder.view.txtTitle.text = articles.get(position).title
            holder.view.txtDescription.text = articles.get(position).description

            Glide.with(context)
                .load(Uri.parse(articles.get(position).urlToImage))
                .into(holder.view.newsImage)

            holder.view.newsItemContainer.setOnClickListener {
                // open chrome custom tab here
                val url = articles.get(position).url

                val builder = CustomTabsIntent.Builder()
                builder.setShowTitle(true)
                val customTabsIntent : CustomTabsIntent = builder.build()
                customTabsIntent.launchUrl(context, Uri.parse(url))
            }
        }
    }

    override fun getItemCount(): Int {
//        return articles.size
        return 50
    }

    fun setArticlesList(articleList: List<Articles>) {
        this.articles = articleList as ArrayList<Articles>
        notifyDataSetChanged()
    }

    class NewsItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    }
}