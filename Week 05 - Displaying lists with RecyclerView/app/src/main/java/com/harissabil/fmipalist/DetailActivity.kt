package com.harissabil.fmipalist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.harissabil.fmipalist.data.Dept
import com.harissabil.fmipalist.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dept = intent.getParcelableExtra<Dept>("dept")

        binding.apply {
            tvName.text = dept?.name
            ivImage.load(dept?.imageUrl)
            tvDescription.text = dept?.description
        }
    }
}