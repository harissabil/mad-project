package com.harissabil.fmipalist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.harissabil.fmipalist.data.DataSource
import com.harissabil.fmipalist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val deptList = DataSource.provideDeptList()
        val adapter = DeptListAdapter(deptList)
        binding.rvDept.adapter = adapter
        binding.rvDept.setHasFixedSize(true)
        binding.rvDept.layoutManager = LinearLayoutManager(this)
    }
}