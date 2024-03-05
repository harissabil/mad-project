package com.harissabil.counter

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var counter = 0

    fun increment() {
        counter++
    }

    fun decrement() {
        counter--
    }
}