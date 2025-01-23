package com.example.p0361_sqlitequery

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), OnClickListener {
    val LOG_TAG: String = "myLogs"

    var name: Array<String> = arrayOf(
        "Китай", "США", "Бразилия", "Россия", "Япония",
        "Германия", "Египет", "Италия", "Франция", "Канада"
    )
    var people: IntArray = intArrayOf(1400, 311, 195, 142, 128, 82, 80, 60, 66, 35)
    var region: Array<String> = arrayOf(
        "Азия", "Америка", "Америка", "Европа", "Азия",
        "Европа", "Африка", "Европа", "Европа", "Америка"
    )

    var btnAll: Button? = null
    var btnFunc: Button? = null
    var btnPeople: Button? = null
    var btnSort: Button? = null
    var btnGroup: Button? = null
    var btnHaving: Button? = null
    var etFunc: EditText? =
        null
    var etPeople: EditText? = null
    var etRegionPeople: EditText? = null
    var rgSort: RadioGroup? = null

    var dbHelper: DBHelper? = null
    var db: SQLiteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnAll = findViewById(R.id.btnAll);
        btnAll?.setOnClickListener(this);

        btnFunc = findViewById(R.id.btnFunc);
        btnFunc?.setOnClickListener(this);

        btnPeople = findViewById(R.id.btnPeople);
        btnPeople?.setOnClickListener(this);

        btnSort = findViewById(R.id.btnSort);
        btnSort?.setOnClickListener(this);

        btnGroup = findViewById(R.id.btnGroup);
        btnGroup?.setOnClickListener(this);

        btnHaving = findViewById(R.id.btnHaving);
        btnHaving?.setOnClickListener(this);

        etFunc = findViewById(R.id.etFunc);
        etPeople = findViewById(R.id.etPeople);
        etRegionPeople = findViewById(R.id.etRegionPeople);

        rgSort = findViewById(R.id.rgSort);

        dbHelper = DBHelper(this);
        // подключаемся к базе
        db = dbHelper?.getWritableDatabase();


        val c = db?.query("mytable", null, null, null, null, null, null)

        if (c?.count == 0) {
            val cv = ContentValues()

            for (i in 0 until 10) {
                cv.put("name", name[i])
                cv.put("people", people[i])
                cv.put("region", region[i])
                db?.insert("mytable", null, cv)
            }
        }
        c?.close()
        // закрываем подключение к БД
        dbHelper!!.close()
        // эмулируем нажатие кнопки btnAll для подгрузки данных
        onClick(btnAll);
    }


    @SuppressLint("Range")
    override fun onClick(v: View?) {

        // подключаемся к базе
        db = dbHelper!!.writableDatabase
        val cv = ContentValues()

        // данные с экрана
        val sFunc = etFunc!!.text.toString()
        val sPeople = etPeople!!.text.toString()
        val sRegionPeople = etRegionPeople!!.text.toString()


        // переменные для query
        var columns: Array<String>? = null
        var selection: String? = null
        var selectionArgs: Array<String>? = null
        var groupBy: String? = null
        var having: String? = null
        var orderBy: String? = null

        // курсор
        var c: Cursor? = null

        when (v?.id) {
            R.id.btnAll -> {
                Log.d(LOG_TAG, "--- Все записи ---")
                c = db?.query("mytable", null, null, null, null, null, null)
            }

            R.id.btnFunc -> {
                Log.d(LOG_TAG, "--- Функция $sFunc ---")
                columns = arrayOf(sFunc)
                c = db?.query("mytable", columns, null, null, null, null, null);
            }
            // Население больше, чем
            R.id.btnPeople -> {
                Log.d(LOG_TAG, "--- Население больше $sPeople ---")
                 selection = "people > ?";
                selectionArgs = arrayOf(sPeople)
                c = db?.query(
                    "mytable", null, selection, selectionArgs, null, null,
                    null
                );
            }
            // Население по региону
            R.id.btnGroup -> {
                Log.d(LOG_TAG, "--- Население по региону ---")
                 columns = arrayOf("region", "sum(people) as people")
                groupBy = "region"
                c = db?.query("mytable", columns, null, null, groupBy, null, null)
            }
            // Население по региону больше чем
            R.id.btnHaving -> {
                Log.d(LOG_TAG, "--- Регионы с населением больше $sRegionPeople---")
                val columns = arrayOf("region", "sum(people) as people")
                groupBy = "region";
                having = "sum(people) > $sRegionPeople";
                c = db?.query("mytable", columns, null, null, groupBy, having, null);
            }
            // Сортировка
            R.id.btnSort -> {
                when (rgSort?.checkedRadioButtonId) {
                    R.id.rName -> {
                        Log.d(LOG_TAG, "--- Сортировка по наименованию ---");
                        orderBy = "name";
                    }

                    R.id.rPeople -> {
                        Log.d(LOG_TAG, "--- Сортировка по населению ---");
                        orderBy = "people";
                    }

                    R.id.rRegion -> {
                        Log.d(LOG_TAG, "--- Сортировка по региону ---");
                        orderBy = "region";
                    }
                }
                c = db?.query("mytable", null, null, null, null, null, orderBy);
            }
        }

        if (c != null) {
            if (c.moveToFirst()) {
                var str: String
                do {
                    str = ""
                    for (cn in c.columnNames) {
                        str = str.plus(cn + " = " + c.getString(c.getColumnIndex(cn)) + "; ")
                    }
                    Log.d(LOG_TAG, str)
                } while (c.moveToNext())
            }
            c.close()
        } else {
            Log.d(LOG_TAG, "Cursor is null")
        }

        dbHelper?.close()

    }

    inner class DBHelper(context: Context?) :
        SQLiteOpenHelper(context, "myDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase) {
            Log.d(LOG_TAG, "--- onCreate database ---")
            // создаем таблицу с полями
            db.execSQL(
                "create table mytable ("
                        + "id integer primary key autoincrement," + "name text,"
                        + "people integer," + "region text" + ");"
            )

        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        }
    }
}