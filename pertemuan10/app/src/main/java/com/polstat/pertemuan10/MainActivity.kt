package com.polstat.pertemuan10

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private lateinit var txt1: TextView
    private lateinit var btn1: Button
    private lateinit var btn2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Pertemuan 10"

        txt1 = findViewById(R.id.txtview1)
        btn1 = findViewById(R.id.button)
        btn2 = findViewById(R.id.button2)

        btn2.setOnClickListener {
            txt1.text = "Button 2 Clicked"
        }
    }

    fun btnClick(view: View) {
        txt1.text = "Button Clicked"
    }
}
