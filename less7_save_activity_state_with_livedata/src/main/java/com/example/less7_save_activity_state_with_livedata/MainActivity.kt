package com.example.less7_save_activity_state_with_livedata

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null
    private var btn: Button? = null
    private var editText: EditText? = null
    private var recView: RecyclerView? = null
    private var users: List<User> = ArrayList()

    //инициализируем ViewModel лениво
    private val userViewModel by lazy { ViewModelProvider(this)[UserViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recView = findViewById(R.id.recyclerView)

        //инициализируем адаптер и присваиваем его списку
        val adapter = UserAdapter(
            context = this,
            userList = users
        )
        recView?.layoutManager = LinearLayoutManager(this)
        recView?.adapter = adapter

        //подписываем адаптер на изменения списка
        userViewModel.getListUsers().observe(this, Observer {
            it.let { adapter.refreshUsers(it) }
        })
    }

    //создаем меню
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.refresh -> {
                userViewModel.updateListUsers()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}


//        сохранять состояние приложения можно так
//        textView = findViewById(R.id.textView)
//        editText = findViewById(R.id.editTextText)
//        btn = findViewById(R.id.button)
//
//        btn?.setOnClickListener {
//            textView?.text = editText?.text
//        }
//    }
//
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//
//        outState.run {
//            putString("KEY", textView?.text.toString())
//        }
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//
//        textView?.text = savedInstanceState.getString("KEY")
//    }
