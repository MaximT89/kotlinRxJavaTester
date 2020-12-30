package com.example.kotlintest

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.kotlintest.R.id.*
import com.example.kotlintest.data.db.AppDatabase
import com.example.kotlintest.data.db.PersonModelDao
import com.example.kotlintest.data.db.PersonTable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers.io

class MainActivity : AppCompatActivity() {

    lateinit var mTextFirst: TextView
    lateinit var mBtnGoToSecondActivity: Button
    lateinit var mBtnCreateText: Button
    lateinit var mEditName: EditText
    lateinit var mEditAge: EditText

    private var db: AppDatabase? = null
    private var personDao: PersonModelDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = AppDatabase.getAppDataBase(context = this)
        personDao = db?.personDAO()

        init()
    }

    @SuppressLint("CheckResult")
    private fun init() {
        mTextFirst = findViewById(textPerson)
        mBtnGoToSecondActivity = findViewById(btnGoToSecondActivity)
        mBtnCreateText = findViewById(btnCreateText)
        mEditName = findViewById(editName)
        mEditAge = findViewById(editAge)

        mBtnGoToSecondActivity.setOnClickListener {
            toastMe()
            goToSecondActivity()
        }

        mBtnCreateText.setOnClickListener {
            Observable.fromCallable {
                val person = PersonTable(mEditName.text.toString(), mEditAge.text.toString().toInt())
                personDao?.insertPerson(person)
            }.subscribeOn(io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    toastMe()
                }
        }
    }

    private fun toastMe() {
        Toast.makeText(this, "Hello toast!", Toast.LENGTH_LONG).show()
    }

    private fun goToSecondActivity() {
        startActivity(Intent(this, SecondActivity::class.java))
    }
}