package com.polstat.pertemuan11

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private lateinit var btn: Button
    private lateinit var txt1: TextView

    private val pickAudioLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val selectedFileUri: Uri? = result.data?.data
            txt1.text = "Selected File: $selectedFileUri"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Pertemuan 11"

        // Inisialisasi Komponen/Elemen
        btn = findViewById(R.id.button)
        txt1 = findViewById(R.id.txtview1)
    }

    fun btnClick(view: View) {
        val myIntent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = "audio/*" // Tampilkan semua file audio
        }
        pickAudioLauncher.launch(myIntent)
    }
}