package com.polstat.pertemuan10

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Pertemuan 10"

        val inputSide: EditText = findViewById(R.id.inputSide)
        val calculateButton: Button = findViewById(R.id.calculateButton)
        val resultText: TextView = findViewById(R.id.resultText)

        calculateButton.setOnClickListener {
            val sideText = inputSide.text.toString()

            if (sideText.isEmpty()) {
                Toast.makeText(this, "Masukkan nilai sisi terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                val side = sideText.toDouble()
                val area = side * side
                resultText.text = "Luas Persegi: $area"
            }
        }
    }
}
