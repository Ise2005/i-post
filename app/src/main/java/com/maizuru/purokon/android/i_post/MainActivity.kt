package com.maizuru.purokon.android.i_post

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        /*window.statusBarColor = Color.RED*/ //一番上の色を変える
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//__________________________________________________________________________________________________
        val list: ListView = findViewById(R.id.choices1)
        list.visibility = View.INVISIBLE

        val button1: ImageButton = findViewById(R.id.recipient1)
        button1.setOnClickListener {
            val intent = Intent(this, Sub1Activity::class.java)
            startActivity(intent)
        }
        button1.setOnLongClickListener{
            val intent = Intent(this, Setup::class.java)
            startActivity(intent)
            true
        }

        val button2: ImageButton = findViewById(R.id.recipient2)
        button2.setOnClickListener {
            val intent = Intent(this, Sub2Activity::class.java)
            startActivity(intent)
        }
        val button3: ImageButton = findViewById(R.id.recipient3)
        button3.setOnClickListener {
            val intent = Intent(this, Sub3Activity::class.java)
            startActivity(intent)
        }
        val button4: ImageButton = findViewById(R.id.recipient4)
        button4.setOnClickListener {
            val intent = Intent(this, Sub4Activity::class.java)
            startActivity(intent)
        }
    }
}