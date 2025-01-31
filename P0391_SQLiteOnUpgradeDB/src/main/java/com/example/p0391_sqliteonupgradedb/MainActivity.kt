package com.example.p0391_sqliteonupgradedb


import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log


class MainActivity : Activity() {
    val LOG_TAG: String = "myLogs"

    val DB_NAME: String = "staff" // имя БД
    val DB_VERSION: Int = 2 // версия БД

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbh: DBHelper = DBHelper(this)
        val db = dbh.writableDatabase
        Log.d(LOG_TAG, " --- Staff db v." + db.version + " --- ")
        writeStaff(db)
        dbh.close()
    }

    // запрос данных и вывод в лог
    private fun writeStaff(db: SQLiteDatabase) {
        var c = db.rawQuery("select * from people", null)
        logCursor(c, "Table people")
        c.close()

        c = db.rawQuery("select * from position", null)
        logCursor(c, "Table position")
        c.close()

        val sqlQuery = ("select PL.name as Name, PS.name as Position, salary as Salary "
                + "from people as PL "
                + "inner join position as PS "
                + "on PL.posid = PS.id ")
        c = db.rawQuery(sqlQuery, null)
        logCursor(c, "inner join")
        c.close()
    }

    // вывод в лог данных из курсора
    @SuppressLint("Range")
    fun logCursor(c: Cursor?, title: String) {
        if (c != null) {
            if (c.moveToFirst()) {
                Log.d(LOG_TAG, title + ". " + c.count + " rows")
                val sb = StringBuilder()
                do {
                    sb.setLength(0)
                    for (cn in c.columnNames) {
                        sb.append(
                            (cn + " = "
                                    + c.getString(c.getColumnIndex(cn)) + "; ")
                        )
                    }
                    Log.d(LOG_TAG, sb.toString())
                } while (c.moveToNext())
            }
        } else Log.d(LOG_TAG, "$title. Cursor is null")
    }

    // класс для работы с БД
    internal inner class DBHelper(context: Context?) :
        SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
        override fun onCreate(db: SQLiteDatabase) {
            Log.d(LOG_TAG, " --- onCreate database --- ")

            val people_name = arrayOf(
                "Иван", "Марья", "Петр", "Антон", "Даша",
                "Борис", "Костя", "Игорь"
            )
            val people_posid = intArrayOf(2, 3, 2, 2, 3, 1, 2, 4)


            // данные для таблицы должностей
            val position_id = intArrayOf(1, 2, 3, 4)
            val position_name = arrayOf(
                "Директор", "Программер", "Бухгалтер",
                "Охранник"
            )
            val position_salary = intArrayOf(15000, 13000, 10000, 8000)

            val cv = ContentValues()


            // создаем таблицу должностей
            db.execSQL(
                ("create table position (" + "id integer primary key,"
                        + "name text, salary integer" + ");")
            )


            // заполняем ее
            for (i in position_id.indices) {
                cv.clear()
                cv.put("id", position_id[i])
                cv.put("name", position_name[i])
                cv.put("salary", position_salary[i])
                db.insert("position", null, cv)
            }


            // создаем таблицу людей
            db.execSQL(
                ("create table people ("
                        + "id integer primary key autoincrement,"
                        + "name text, posid integer);")
            )


            // заполняем ее
            for (i in people_name.indices) {
                cv.clear()
                cv.put("name", people_name[i])
                cv.put("posid", people_posid[i])
                db.insert("people", null, cv)
            }
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            Log.d(
                LOG_TAG, (" --- onUpgrade database from " + oldVersion
                        + " to " + newVersion + " version --- ")
            )

            if (oldVersion == 1 && newVersion == 2) {
                val cv = ContentValues()


                // данные для таблицы должностей
                val position_id = intArrayOf(1, 2, 3, 4)
                val position_name = arrayOf(
                    "Директор", "Программер",
                    "Бухгалтер", "Охранник"
                )
                val position_salary = intArrayOf(15000, 13000, 10000, 8000)

                db.beginTransaction()
                try {
                    // создаем таблицу должностей
                    db.execSQL(
                        ("create table position ("
                                + "id integer primary key,"
                                + "name text, salary integer);")
                    )


                    // заполняем ее
                    for (i in position_id.indices) {
                        cv.clear()
                        cv.put("id", position_id[i])
                        cv.put("name", position_name[i])
                        cv.put("salary", position_salary[i])
                        db.insert("position", null, cv)
                    }

                    db.execSQL("alter table people add column posid integer;")

                    for (i in position_id.indices) {
                        cv.clear()
                        cv.put("posid", position_id[i])
                        db.update(
                            "people", cv, "position = ?",
                            arrayOf(position_name[i])
                        )
                    }

                    db.execSQL(
                        "create temporary table people_tmp ("
                                + "id integer, name text, position text, posid integer);"
                    )

                    db.execSQL("insert into people_tmp select id, name, position, posid from people;")
                    db.execSQL("drop table people;")

                    db.execSQL(
                        ("create table people ("
                                + "id integer primary key autoincrement,"
                                + "name text, posid integer);")
                    )

                    db.execSQL("insert into people select id, name, posid from people_tmp;")
                    db.execSQL("drop table people_tmp;")

                    db.setTransactionSuccessful()
                } finally {
                    db.endTransaction()
                }
            }
        }
    }
}