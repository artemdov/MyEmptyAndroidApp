package com.example.less_8_data_binding.data


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class SimpleViewModel : ViewModel() {
    private val _name = MutableLiveData("Tom")
    private val _lastName = MutableLiveData("Soyer")
    private val _likes = MutableLiveData(0)

    val name: LiveData<String> = _name
    val lastName: LiveData<String> = _lastName
    var likes: MutableLiveData<Int> = _likes


    fun onLike() {
        _likes.value = (_likes.value ?: 0) + 1
    }

//    fun popularity(): LiveData<Popularity> = _likes.map {
//        when {
//            it > 9 -> Popularity.STAR
//            it > 4 -> Popularity.POPULAR
//            else -> Popularity.NORMAL
//        }
//    }
}

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}