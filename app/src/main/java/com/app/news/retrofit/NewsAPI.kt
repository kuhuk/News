package com.app.news.retrofit

import com.app.news.response.NewsList
import retrofit2.Response
import retrofit2.http.GET

interface NewsAPI {
    @GET("everything?q=Apple&from=2022-11-16&sortBy=popularity&apiKey=d275bb877f49416792a290a3d8ef7412")
    suspend fun getNewsList(): NewsList
}