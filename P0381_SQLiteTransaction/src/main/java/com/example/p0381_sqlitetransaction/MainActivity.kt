package com.example.p0381_sqlitetransaction

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log


class MainActivity : Activity() {
    val LOG_TAG: String = "myLogs"

    var dbh: DBHelper? = null
    var db: SQLiteDatabase? = null

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(LOG_TAG, "--- onCreate Activity ---")
        dbh = DBHelper(this)
        myActions()
    }
//форма использования транзакций
//    db.beginTransaction();
//    try {
//        ...
//        db.setTransactionSuccessful();
//    } finally {
//        db.endTransaction();
//    }


    fun myActions() {
        db = dbh!!.writableDatabase
        val db2 = dbh!!.writableDatabase
        Log.d(LOG_TAG, "db = db2 - " + (db == db2))
        Log.d(LOG_TAG, "db open - " + db?.isOpen + ", db2 open - " + db2.isOpen)
        db?.close()
        Log.d(LOG_TAG, "db open - " + db?.isOpen + ", db2 open - " + db2.isOpen)
    }

    private fun insert(db: SQLiteDatabase?, table: String, value: String) {
        Log.d(LOG_TAG, "Insert in table $table value = $value")
        val cv = ContentValues()
        cv.put("val", value)
        db!!.insert(table, null, cv)
    }

    @SuppressLint("Range")
    fun read(db: SQLiteDatabase?, table: String) {
        Log.d(LOG_TAG, "Read table $table")
        val c = db!!.query(table, null, null, null, null, null, null)
        if (c != null) {
            Log.d(LOG_TAG, "Records count = " + c.count)
            if (c.moveToFirst()) {
                do {
                    Log.d(LOG_TAG, c.getString(c.getColumnIndex("val")))
                } while (c.moveToNext())
            }
            c.close()
        }
    }

    private fun delete(db: SQLiteDatabase?, table: String) {
        Log.d(LOG_TAG, "Delete all from table $table")
        db!!.delete(table, null, null)
    }

    // класс для работы с БД
    inner class DBHelper(context: Context?) :
        SQLiteOpenHelper(context, "myDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase) {
            Log.d(LOG_TAG, "--- onCreate database ---")

            db.execSQL(
                ("create table mytable ("
                        + "id integer primary key autoincrement,"
                        + "val text"
                        + ");")
            )
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        }
    }
}