package com.example.goodnews.viewModel

import android.util.Log.d
import android.util.Log.e
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.goodnews.Resource
import com.example.goodnews.api.AllNewsApi
import com.example.goodnews.api.AllNewsApi.retrofitService
import com.example.goodnews.data.Article
import com.example.goodnews.data.News
import com.example.goodnews.repo.AllNewsRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class AllNewsViewModel(private val repository: AllNewsRepository): ViewModel() {

    private val _res = MutableLiveData<Resource<News>>()
    val res : LiveData<Resource<News>>
        get() = _res

    init {
        viewModelScope.launch {
        repository.getTechNews()
       // repository.getSportNews()
        }
    }

   /** private fun getNews() {
        viewModelScope.launch {
            try {
                val listResult = AllNewsApi.retrofitService.getTechNews()
                _res.value = "Success: ${listResult.size} Mars photos retrieved"
            } catch (e: Exception) {
                _res.value = "Failure: ${e.message}"
            }
        }
    }**/






}