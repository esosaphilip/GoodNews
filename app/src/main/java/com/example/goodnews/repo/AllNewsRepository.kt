package com.example.goodnews.repo

import com.example.goodnews.api.AllNewsApi
import com.example.goodnews.api.NewsApiService
import com.example.goodnews.data.Article
import com.example.goodnews.data.News
import com.example.goodnews.data.Sport
import retrofit2.Call
import retrofit2.Response

class AllNewsRepository( private val apiService: NewsApiService) {

    suspend fun getTechNews(): Response<News> = AllNewsApi.retrofitService.getTechNews()
   // fun getSportNews(): Response<Sport> = AllNewsApi.retrofitService.getSportNews()

}