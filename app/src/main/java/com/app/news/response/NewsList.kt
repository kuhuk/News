package com.app.news.response

data class NewsList(val status: String,
                    val totalResults: Int,
                    val articles: List<Articles>)