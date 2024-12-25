package com.polstat.pertemuan11

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SendingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sending)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextSurname = findViewById<EditText>(R.id.editTextSurname)
        val editTextAge = findViewById<EditText>(R.id.editTextAge)
        val buttonSend = findViewById<Button>(R.id.buttonSend)

        buttonSend.setOnClickListener {
            val name = editTextName.text.toString()
            val surname = editTextSurname.text.toString()
            val age = editTextAge.text.toString()

            val intent = Intent(this, ReceiveActivity::class.java).apply {
                putExtra("name", name)
                putExtra("surname", surname)
                putExtra("age", age)
            }
            startActivity(intent)
        }
    }
}