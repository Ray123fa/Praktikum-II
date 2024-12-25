package com.polstat.pertemuan11

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReceiveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive)

        val textViewName = findViewById<TextView>(R.id.textViewName)
        val textViewSurname = findViewById<TextView>(R.id.textViewSurname)
        val textViewAge = findViewById<TextView>(R.id.textViewAge)

        val name = intent.getStringExtra("name")
        val surname = intent.getStringExtra("surname")
        val age = intent.getStringExtra("age")

        textViewName.text = "Name: $name"
        textViewSurname.text = "Surname: $surname"
        textViewAge.text = "Age: $age"
    }
}