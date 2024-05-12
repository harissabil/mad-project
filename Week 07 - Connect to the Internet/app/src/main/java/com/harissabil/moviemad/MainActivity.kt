package com.harissabil.moviemad

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.harissabil.moviemad.data.response.ResultsItem
import com.harissabil.moviemad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.movieList.observe(this) {
            if (it != null) {
                setMovieData(it)
            }
        }

        binding.rvMovie.layoutManager = LinearLayoutManager(this)
    }

    private fun setMovieData(movieList: List<ResultsItem>) {
        val adapter = MovieListAdapter(movieList)
        binding.rvMovie.adapter = adapter
    }
}