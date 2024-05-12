package com.harissabil.moviemad

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harissabil.moviemad.data.response.MovieResponse
import com.harissabil.moviemad.data.response.ResultsItem
import com.harissabil.moviemad.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val _movieList = MutableLiveData<List<ResultsItem>?>()
    val movieList: LiveData<List<ResultsItem>?> = _movieList

    init {
        fetchMovieData()
    }

    private fun fetchMovieData() {
        val client = ApiConfig.getApiService().getMovieList("Pokemon")
        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    Log.d("MainActivity", "onResponse: ${response.body()}")
                    val movieList = response.body()?.results
                    if (movieList != null) {
                        _movieList.postValue(movieList)
                    }
                }
            }

            override fun onFailure(p0: Call<MovieResponse>, p1: Throwable) {
                Log.e("MainActivity", "onFailure: ${p1.message}")
            }

        })
    }
}