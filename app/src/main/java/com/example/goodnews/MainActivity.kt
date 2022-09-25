package com.example.goodnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.goodnews.api.AllNewsApi
import com.example.goodnews.api.NewsApiService
import com.example.goodnews.databinding.ActivityMainBinding
import com.example.goodnews.repo.AllNewsRepository
import com.example.goodnews.util.Util
import com.example.goodnews.util.Util.API_KEY
import com.example.goodnews.viewModel.AllNewsViewModel
import com.example.goodnews.viewModel.AllNewsViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var allNewsViewModel: AllNewsViewModel
    private lateinit var apiService: NewsApiService
    private lateinit var repository:  AllNewsRepository
    private lateinit var allNewsApi : AllNewsApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        apiService = AllNewsApi.retrofitService
        repository = AllNewsRepository(apiService)
        allNewsViewModel = AllNewsViewModel(repository)
        allNewsViewModel = ViewModelProvider(this, AllNewsViewModelFactory(repository))[allNewsViewModel::class.java]
        allNewsViewModel.res.observe(this) {
            d("load","onCreate: ${it.toString()}")
        }

    }



}