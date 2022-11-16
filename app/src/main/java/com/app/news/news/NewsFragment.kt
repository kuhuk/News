package com.app.news.news

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.news.R
import com.app.news.response.NewsList
import com.app.news.retrofit.NewsAPI
import com.app.news.retrofit.RetrofitHelper
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.fragment_news.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsFragment : Fragment() {

    companion object {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_news, container, false)

        getNewsList()

        return view
    }

    private fun getNewsList() {
        val newsAPI = RetrofitHelper.getInstance().create(NewsAPI::class.java)

        // launching a new coroutine
        GlobalScope.launch {
            val newsList: NewsList = newsAPI.getNewsList()
            setUpRecyclerView(newsList)
        }
    }

    private fun setUpRecyclerView(newsList: NewsList) {
        activity?.runOnUiThread {
            recyclerViewNews.layoutManager = LinearLayoutManager(activity)
            recyclerViewNews.adapter = NewsAdapter(newsList)
        }
    }
}