package com.misbahulihsan.kotlinsemarang

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class MyDatabaseHelper private constructor(context: Context) : ManagedSQLiteOpenHelper(
    context, "human.db",
    null, 1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(
            ManusiaContract.TABLE_HUMAN,
            true,
            ManusiaContract.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            ManusiaContract.NAME to TEXT,
            ManusiaContract.ADDRESS to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(ManusiaContract.TABLE_HUMAN)
    }

    companion object {
        private var instance: MyDatabaseHelper? = null

        fun getInstance(context: Context): MyDatabaseHelper {
            if (instance == null) {
                instance = MyDatabaseHelper(context)
            }
            return instance as MyDatabaseHelper

        }

    }
}

val Context.database: MyDatabaseHelper
    get() = MyDatabaseHelper.getInstance(applicationContext)