package com.app.news.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.news.response.Articles
import com.app.news.response.NewsList
import com.app.news.retrofit.NewsAPI
import com.app.news.retrofit.RetrofitHelper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {
    // Live data
    private var articlesListLiveData = MutableLiveData<List<Articles>>()

    fun getNews() {
        val newsAPI = RetrofitHelper.getInstance().create(NewsAPI::class.java)

        // launching a new coroutine
        GlobalScope.launch {
            val newsList: NewsList = newsAPI.getNewsList()
            if(newsList != null) {
                articlesListLiveData.postValue(newsList.articles)
            }
        }
    }

    fun observeArticlesListLiveData(): LiveData<List<Articles>> {
        return articlesListLiveData
    }
}