package com.example.p0371_sqliteinnerjoin

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val LOG_TAG: String = "myLogs"

    // данные для таблицы должностей
    var position_id: IntArray = intArrayOf(1, 2, 3, 4)
    var position_name: Array<String> = arrayOf("Директор", "Программер", "Бухгалтер", "Охранник")
    var position_salary: IntArray = intArrayOf(15000, 13000, 10000, 8000)

    // данные для таблицы людей
    var people_name: Array<String> =
        arrayOf("Иван", "Марья", "Петр", "Антон", "Даша", "Борис", "Костя", "Игорь")
    var people_posid: IntArray = intArrayOf(2, 3, 2, 2, 3, 1, 2, 4)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        // Подключаемся к БД
        val dbh: DBHelper = DBHelper(this)
        val db: SQLiteDatabase = dbh.getWritableDatabase()


        // выводим в лог данные по должностям
        Log.d(LOG_TAG, "--- Table position ---")


        // Описание курсора
        var c = db.query("position", null, null, null, null, null, null)
        logCursor(c)
        c.close()
        Log.d(LOG_TAG, "--- ---")


        // выводим в лог данные по людям
        Log.d(LOG_TAG, "--- Table people ---")
        c = db.query("people", null, null, null, null, null, null)
        logCursor(c)
        c.close()
        Log.d(LOG_TAG, "--- ---")

        // выводим результат объединения
        // используем rawQuery
        Log.d(LOG_TAG, "--- INNER JOIN with rawQuery---")
        val sqlQuery = ("select PL.name as Name, PS.name as Position, salary as Salary "
                + "from people as PL "
                + "inner join position as PS "
                + "on PL.posid = PS.id "
                + "where salary > ?")

        c = db?.rawQuery(sqlQuery, arrayOf("12000"))
        logCursor(c);
        c.close();
        Log.d(LOG_TAG, "--- ---")


        // выводим результат объединения
        // используем query
        Log.d(LOG_TAG, "--- INNER JOIN with query---")
        val table = "people as PL inner join position as PS on PL.posid = PS.id"
        val columns = arrayOf("PL.name as Name", "PS.name as Position", "salary as Salary")
        val selection = "salary < ?"
        val selectionArgs = arrayOf("12000")
        c = db.query(table, columns, selection, selectionArgs, null, null, null)
        logCursor(c)
        c.close()
        Log.d(LOG_TAG, "--- ---")


        // закрываем БД
        dbh.close()
    }

    @SuppressLint("Range")
    fun logCursor(cursor: Cursor?) {
        cursor?.let { c ->
            if (c.moveToFirst()) {
                do {
                    var str = ""
                    for (cn in c.columnNames) {
                        str += "$cn = ${c.getString(c.getColumnIndex(cn))}; "
                    }
                    Log.d(LOG_TAG, str)
                } while (c.moveToNext())
            }
        } ?: run {
            Log.d(LOG_TAG, "Cursor is null")
        }
    }

    // класс для работы с БД
    inner class DBHelper(context: Context?) :
        SQLiteOpenHelper(context, "myDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase) {
            Log.d("myLogs", "--- onCreate database ---")

            val cv = ContentValues()

            // создаем таблицу должностей
            db.execSQL(
                "create table position ("
                        + "id integer primary key,"
                        + "name text," + "salary integer"
                        + ");"
            );


            // заполняем ее
            for (i in position_id.indices) {
                cv.clear()
                cv.put("id", position_id[i])
                cv.put("name", position_name[i])
                cv.put("salary", position_salary[i])
                db.insert("position", null, cv)
            }

            // создаем таблицу с полями
            db.execSQL(
                "create table people ("
                        + "id integer primary key autoincrement,"
                        + "name text,"
                        + "posid integer" // добавьте поле posid, соответствующее вашей логике
                        + ");"
            )

            for (i in people_name.indices) {
                cv.clear()
                cv.put("name", people_name[i])
                cv.put("posid", people_posid[i])
                db.insert("people", null, cv)
            }

        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        }
    }
}