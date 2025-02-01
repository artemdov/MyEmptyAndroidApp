package com.example.less_8_data_binding.ui

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.less_8_data_binding.data.SimpleViewModel
import com.example.less_8_data_binding.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProvider(this)[SimpleViewModel::class.java] }
    private var defaultProgressBarColor: ColorStateList? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this // Важно! Data Binding должен знать об жизненном цикле

        binding.viewmodel = viewModel


        //аналогичный код как ниже
//        viewModel.likes.observe(this) { likes ->
//            binding.progressBar.visibility = if (likes == 0) View.GONE else View.VISIBLE
//
//            binding.progressBar.progress =
//                (likes * binding.progressBar.max / 5).coerceAtMost(binding.progressBar.max)
//        }


        // Observer для изменения UI
        viewModel.likes.observe(this) { likes ->
            with(binding.progressBar) {
                visibility = if (likes == 0) View.GONE else View.VISIBLE
                progress = calculateProgress(likes, max)

                progressTintList = ColorStateList.valueOf(
                    when {
                        likes < 3 -> Color.DKGRAY
                        likes < 5 -> Color.GREEN
                        else -> Color.RED
                    }
                )
            }
        }
    }

    // Функция для расчёта прогресса
    private fun calculateProgress(likes: Int, max: Int): Int {
        return (likes * max / 5).coerceAtMost(max)
    }
}