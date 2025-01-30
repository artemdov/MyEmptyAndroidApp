package com.example.less_8_data_binding

import androidx.lifecycle.ViewModel

class SimpleViewModel : ViewModel() {
    val name = "Garry"
    val lastName = "Hopper"
    private var likes = 0

    fun onLike() {
        likes++
    }

    fun popularity() = when {
        likes > 9 -> Popularity.STAR
        likes > 4 -> Popularity.POPULAR
        else -> Popularity.NORMAL
    }
}

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}