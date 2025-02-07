package com.example.architecture_app_added_dagger.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.architecture_app_added_dagger.R
import com.example.architecture_app_added_dagger.app.App
import javax.inject.Inject

class MainActivity : AppCompatActivity(), OnClickListener {

    private var dataTextView: TextView? = null
    private var editTextView: EditText? = null

    private lateinit var vm: MainViewModel

    @Inject
    lateinit var vmFactory: MainViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent.inject(this)

        Log.d("AAA", "Activity created")

        vm = ViewModelProvider(this, vmFactory)[MainViewModel::class.java]

        dataTextView = findViewById(R.id.textView)
        editTextView = findViewById(R.id.editTextTextMultiLine)
        val getData = findViewById<Button>(R.id.button)
        val savedata = findViewById<TextView>(R.id.button2)

        getData.setOnClickListener(this)

        savedata.setOnClickListener(this)

        vm.resultLiveData.observe(this) { text ->
            dataTextView?.text = text
        }

    }


    override fun onClick(v: View) {

        when (v.id) {
            R.id.button -> {
                vm.load()

            }

            R.id.button2 -> {
                val textName = editTextView?.text.toString()
                vm.save(textName)
            }
        }

    }
}