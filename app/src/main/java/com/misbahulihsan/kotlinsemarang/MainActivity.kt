package com.misbahulihsan.kotlinsemarang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_btn_save.onClick {
            saveData()
        }

        main_btn_refresh.onClick {
            readData()
        }
    }

    private fun readData() {
        database.use {
            val result = select(ManusiaContract.TABLE_HUMAN)
            val list = result.parseList(classParser<ManusiaContract>())
            Log.d("LIST", list.toString())
        }
    }

    private fun saveData() {
        database.use {
            insert(
                ManusiaContract.TABLE_HUMAN,
                ManusiaContract.NAME to main_edt_name.text.toString(),
                ManusiaContract.ADDRESS to main_edt_address.text.toString()

            )
        }
    }


}
