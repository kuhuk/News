package com.app.news.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.news.R
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment() {

    private lateinit var newsAdapter: NewsAdapter
    private lateinit var articlesViewModel: NewsViewModel

    companion object {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        getNews()
    }

    private fun getNews() {
        articlesViewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        articlesViewModel.getNews()
        articlesViewModel.observeArticlesListLiveData().observe(viewLifecycleOwner
        ) { articlesList -> newsAdapter.setArticlesList(articlesList) }
    }

    private fun setUpRecyclerView() {
        newsAdapter = NewsAdapter(requireContext())
        recyclerViewNews.layoutManager = LinearLayoutManager(activity)
        recyclerViewNews.adapter = newsAdapter
    }
}