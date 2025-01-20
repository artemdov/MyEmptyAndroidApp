package com.example.p0141_menuadv


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.TextView
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {
    private var chb: CheckBox? = null
    private var tv: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        chb = findViewById(R.id.chbExtMenu)
        tv = findViewById(R.id.textView)

        Log.d(chb?.isChecked.toString(), "@@@ggg")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // TODO Auto-generated method stub
        // добавляем пункты меню
        menu.add(0, 1, 0, "add");
        menu.add(0, 2, 0, "edit");
        menu.add(0, 3, 3, "delete");
        menu.add(1, 4, 1, "copy");
        menu.add(1, 5, 2, "paste");
        menu.add(1, 6, 4, "exit");

        return super.onCreateOptionsMenu(menu);
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        chb?.let { menu?.setGroupVisible(1, it.isChecked) };

        Log.d(chb?.isChecked.toString(), "@@@eeee")
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val sb = StringBuilder()
        // Выведем в TextView информацию о нажатом пункте меню
        Log.d(chb?.isChecked.toString(), "@@@eeee")
        sb.append("Item Menu")
        sb.append("\r\n groupId: " + item.groupId)
        sb.append("\r\n itemId: " + item.itemId)
        sb.append("\r\n order: " + item.order)
        sb.append("\r\n title: " + item.title)

        tv?.text = sb.toString()

        return super.onOptionsItemSelected(item)
    }
}