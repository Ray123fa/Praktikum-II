package com.polstat.pertemuan11

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi Button
        btn1 = findViewById(R.id.button1)
        btn2 = findViewById(R.id.button2)
        btn3 = findViewById(R.id.button3)
    }

    // Fungsi untuk Button 1
    fun btnClick(view: View) {
        val tlpIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:081234567899"))
        startActivity(tlpIntent)
    }

    // Fungsi untuk Button 2
    fun btn2Click(view: View) {
        val settingIntent = Intent(Settings.ACTION_SETTINGS)
        startActivity(settingIntent)

        // Menampilkan Toast
        Toast.makeText(this, "You have pressed: ${btn2.text}", Toast.LENGTH_LONG).show()
    }

    // Fungsi untuk Button 3
    fun btn3Click(view: View) {
        val searchIntent = Intent(Intent.ACTION_WEB_SEARCH)
        searchIntent.putExtra(SearchManager.QUERY, "intent android")
        startActivity(searchIntent)
    }
}