package com.example.coroutines

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.coroutines.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.buttonLoad.setOnClickListener {
            loadData()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun loadData() {
        binding.progress.isVisible = true
        binding.buttonLoad.isEnabled = false

//       меняем код синхронный на асинхронный ниже
//        val city = loadCity()
//        binding.tvLocation.text = city
//        val temp = loadTemperature(city)
//        binding.tvTemperature.text = temp.toString()
//        binding.progress.isVisible = false
//        binding.progress.isEnabled = true


        //выполнение уже будет в новом потоке
        loadCity { its ->
            binding.tvLocation.text = its
            loadTemperature(its) {
                binding.tvTemperature.text = it.toString()
                binding.progress.isVisible = false
                binding.buttonLoad.isEnabled = true
            }
        }
    }

    private fun loadCity(callback: (String) -> Unit) {

        //создание нового потока
        thread {
            Thread.sleep(5000)
            runOnUiThread {
                callback.invoke(
                    "Moscow"
                )
            }
        }
    }

    private fun loadTemperature(city: String, callback: (Int) -> Unit) {

        thread {
            runOnUiThread {
                Toast.makeText(
                    this, "Loading temp for city: $city",
                    Toast.LENGTH_SHORT
                ).show()
            }

            Thread.sleep(5000)

            runOnUiThread {
                callback.invoke(17)
            }
        }

    }
}