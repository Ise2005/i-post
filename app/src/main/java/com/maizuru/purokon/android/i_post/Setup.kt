package com.maizuru.purokon.android.i_post

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Setup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setup)

        val sharedPref = getSharedPreferences("宛先1", Context.MODE_PRIVATE)

        var savedText = sharedPref.getString("宛先1", "・宛先1")

        val editText = findViewById<EditText>(R.id.yourName)
        editText.setText(savedText)

        val button = findViewById<Button>(R.id.okButton)
        button.setOnClickListener {
            val inputText = editText.text.toString()

            sharedPref.edit().putString("宛先1", inputText).apply()
            savedText = sharedPref.getString("宛先1", "・宛先1")
        }

        val button5 :Button = findViewById(R.id.back)
        button5.setOnClickListener {
            finish()
        }
    }
}