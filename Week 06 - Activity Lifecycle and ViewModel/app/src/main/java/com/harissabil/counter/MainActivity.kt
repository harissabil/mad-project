package com.harissabil.counter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.harissabil.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        println("onCreate called")

        val mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.tvCounter.text = mainViewModel.counter.toString()

        binding.btnIncrement.setOnClickListener {
            mainViewModel.increment()
            binding.tvCounter.text = mainViewModel.counter.toString()
        }

        binding.btnDecrement.setOnClickListener {
            mainViewModel.decrement()
            binding.tvCounter.text = mainViewModel.counter.toString()
        }
    }

    override fun onStart() {
        super.onStart()

        println("onStart called")
    }

    override fun onResume() {
        super.onResume()

        println("onResume called")
    }

    override fun onStop() {
        super.onStop()

        println("onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()

        println("onDestroy called")
    }
}