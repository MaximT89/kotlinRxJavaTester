package com.example.kotlintest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.kotlintest.R.id.*

lateinit var mTextSecond: TextView
lateinit var mBtnSecond: Button

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        init()

        mBtnSecond.setOnClickListener {
            goToFirstActivity()
        }
    }

    private fun init() {
        mTextSecond = findViewById(text_second)
        mBtnSecond = findViewById(btn_second)
    }

    private fun goToFirstActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}
