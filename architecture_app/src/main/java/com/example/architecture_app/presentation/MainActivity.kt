package com.example.architecture_app.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.architecture_app.R
import com.example.architecture_app.data.repository.UserRepositoryImpl
import com.example.architecture_app.domain.models.SaveUserNameParam
import com.example.architecture_app.domain.usecase.GetUserNameUseCase
import com.example.architecture_app.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity(), OnClickListener {

    private var dataTextView: TextView? = null
    private var editTextView: EditText? = null

    //LazyThreadSafetyMode.NONE подключаем чтобы не было многопоточности
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImpl(context = applicationContext) }

    //подключаем юскейсы к активити
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository = userRepository) }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository = userRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        dataTextView = findViewById(R.id.textView)
        editTextView = findViewById(R.id.editTextTextMultiLine)
        val getData = findViewById<Button>(R.id.button)
        val savedata = findViewById<TextView>(R.id.button2)

        getData.setOnClickListener(this)

        savedata.setOnClickListener(this)

    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View) {
        when (v.id) {
            R.id.button -> {
                Log.d("##$$", "###")
                val userName = getUserNameUseCase.execute()
                dataTextView?.text = "${userName.firstName} ${userName.lastName}"

            }

            R.id.button2 -> {
                val textName = editTextView?.text.toString()
                val params = SaveUserNameParam(name = textName)
                val result: Boolean = saveUserNameUseCase.execute(params)

                dataTextView?.text = if (result) textName else "Данные не сохранены"
            }
        }
    }
}