package com.example.p0341_simplesqlite

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText


class MainActivity : Activity(), View.OnClickListener {
    val LOG_TAG: String = "myLogs"

    var btnAdd: Button? = null
    var btnRead: Button? = null
    var btnClear: Button? = null
    var etName: EditText? = null
    var etEmail: EditText? = null
    var btnUpd: Button? = null
    var btnDel: Button? = null
    var etId: EditText? = null

    var dbHelper: DBHelper? = null

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd = findViewById<View>(R.id.btnAdd) as Button
        btnAdd!!.setOnClickListener(this)

        btnRead = findViewById<View>(R.id.btnRead) as Button
        btnRead!!.setOnClickListener(this)

        btnClear = findViewById<View>(R.id.btnClear) as Button
        btnClear!!.setOnClickListener(this)

        btnUpd = findViewById<View>(R.id.btnUpd) as Button
        btnUpd!!.setOnClickListener(this)

        btnDel = findViewById<View>(R.id.btnDel) as Button
        btnDel!!.setOnClickListener(this)

        etName = findViewById<View>(R.id.etName) as EditText
        etEmail = findViewById<View>(R.id.etEmail) as EditText
        etId = findViewById<View>(R.id.etID) as EditText


        // создаем объект для создания и управления версиями БД
        dbHelper = DBHelper(this)
    }


    override fun onClick(v: View) {
        // создаем объект для данных
        val cv = ContentValues()


        // получаем данные из полей ввода
        val name = etName!!.text.toString()
        val email = etEmail!!.text.toString()
        val id = etId!!.text.toString()

        // подключаемся к БД
        val db = dbHelper!!.writableDatabase


        when (v.id) {
            R.id.btnAdd -> {
                Log.d(LOG_TAG, "--- Insert in mytable: ---")

                // подготовим данные для вставки в виде пар: наименование столбца - значение
                cv.put("name", name)
                cv.put("email", email)
                // вставляем запись и получаем ее ID
                val rowID = db.insert("mytable", null, cv)
                Log.d(LOG_TAG, "row inserted, ID = $rowID")
            }

            R.id.btnRead -> {
                Log.d(LOG_TAG, "--- Rows in mytable: ---")
                // делаем запрос всех данных из таблицы mytable, получаем Cursor
                val c = db.query("mytable", null, null, null, null, null, null)


                // ставим позицию курсора на первую строку выборки
                // если в выборке нет строк, вернется false
                if (c.moveToFirst()) {
                    // определяем номера столбцов по имени в выборке

                    val idColIndex = c.getColumnIndex("id")
                    val nameColIndex = c.getColumnIndex("name")
                    val emailColIndex = c.getColumnIndex("email")

                    do {
                        // получаем значения по номерам столбцов и пишем все в лог
                        Log.d(
                            LOG_TAG,
                            "ID = " + c.getInt(idColIndex) +
                                    ", name = " + c.getString(nameColIndex) +
                                    ", email = " + c.getString(emailColIndex)
                        )
                        // переход на следующую строку
                        // а если следующей нет (текущая - последняя), то false - выходим из цикла
                    } while (c.moveToNext())
                } else Log.d(LOG_TAG, "0 rows")
                c.close()
            }

            R.id.btnClear -> {
                Log.d(LOG_TAG, "--- Clear mytable: ---")
                // удаляем все записи
                val clearCount = db.delete("mytable", null, null)
                Log.d(LOG_TAG, "deleted rows count = $clearCount")
            }

            R.id.btnUpd -> {
                if (id.equals("", ignoreCase = true)) return

                Log.d(LOG_TAG, "--- Update mytable: ---")
                // подготовим значения для обновления
                cv.put("name", name);
                cv.put("email", email);
                val updCount = db.update("mytable", cv, "id = ?", arrayOf(id))
                Log.d(LOG_TAG, "updated rows count = $updCount")
            }

            R.id.btnDel -> {
                if (id.equals("", ignoreCase = true)) return

                Log.d(LOG_TAG, "--- Delete from mytable: ---")

                // удаляем по id
                val delCount = db.delete("mytable", "id = ?", arrayOf(id))
                Log.d(LOG_TAG, "deleted rows count = " + delCount)
            }
        }
        // закрываем подключение к БД
        dbHelper!!.close()
    }


    inner class DBHelper(context: Context?) :
        SQLiteOpenHelper(context, "myDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase) {
            Log.d(LOG_TAG, "--- onCreate database ---")
            // создаем таблицу с полями
            db.execSQL(
                ("create table mytable ("
                        + "id integer primary key autoincrement,"
                        + "name text,"
                        + "email text" + ");")
            )
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        }
    }
}