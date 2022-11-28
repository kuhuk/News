package com.app.news.response

data class Articles(val source: Source,
                    val author: String,
                    val title: String,
                    val description: String,
                    val url: String,
                    val publishedAt: String,
                    val content: String,
                    val urlToImage: String)