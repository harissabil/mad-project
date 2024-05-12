package com.harissabil.moviemad.data.retrofit

import com.harissabil.moviemad.data.response.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // query for get movie list
    @GET("3/search/movie")
    fun getMovieList(
        @Query("query") query: String,
        @Query("api_key") apiKey: String = "a608372cd62baa6e65e34b521e7684b9",
    ): Call<MovieResponse>
}