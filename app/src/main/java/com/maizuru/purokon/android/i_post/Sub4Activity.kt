package com.maizuru.purokon.android.i_post

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Sub4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub4)

        val button5 :Button = findViewById(R.id.button5)

        button5.setOnClickListener {
            finish()
        }
    }
}

