package com.example.goodnews.api

import com.example.goodnews.data.Article
import com.example.goodnews.data.News
import com.example.goodnews.data.Sport
import com.example.goodnews.util.Util.API_KEY
import com.example.goodnews.util.Util.BASE_URL
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query


private val moshi = Moshi.Builder()
    .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//@Query("Key") apiKey: String = API_KEY

interface NewsApiService {
    @Headers("apiKey:" + "API_KEY")
    @GET("v2/top-headlines?sources=techcrunch&apiKey=6d2c2a8589704ea298af624c6711506b")
    suspend fun getTechNews( ): Response<News>

   // @GET("v2/top-headlines?country=us&category=sports&apiKey=6d2c2a8589704ea298af624c6711506b")
   // fun getSportNews(@Query("Key") apiKey: String = API_KEY): Response<Sport>
}

object AllNewsApi {
    val retrofitService: NewsApiService by lazy { retrofit.create(NewsApiService::class.java) }
}