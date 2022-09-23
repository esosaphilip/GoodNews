package com.example.goodnews.data

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)