package com.example.p0131_menusimple

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu) // Загрузка меню из XML-файла
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val message = when (item.itemId) {
            R.id.item1 -> "Выбран пункт menu1"
            R.id.item2 -> "Выбран пункт menu2"
            R.id.item3 -> "Выбран пункт menu3"
            R.id.item4 -> "Выбран пункт menu4"
            else -> return super.onOptionsItemSelected(item)
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        return true
    }
}