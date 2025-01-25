package com.polstat.p14part1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UpdateMahasiswaActivity : AppCompatActivity() {
    private lateinit var nimEdt: EditText
    private lateinit var namaEdt: EditText
    private lateinit var kelasEdt: EditText
    private lateinit var nohpEdt: EditText
    private lateinit var updateMahasiswaBtn: Button
    private lateinit var deleteMahasiswaBtn: Button
    private lateinit var dbHandler: DBHandler

    private var nim: String? = null
    private var nama: String? = null
    private var kelas: String? = null
    private var nohp: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mahasiswa_update)

        // Inisialisasi UI
        nimEdt = findViewById(R.id.nimEdtEditText)
        namaEdt = findViewById(R.id.namaEdtEditText)
        kelasEdt = findViewById(R.id.kelasEdtEditText)
        nohpEdt = findViewById(R.id.nohpEdtEditText)
        updateMahasiswaBtn = findViewById(R.id.updateButton)
        deleteMahasiswaBtn = findViewById(R.id.deleteButton)

        dbHandler = DBHandler(this)

        // Mendapatkan data dari Intent
        nim = intent.getStringExtra("nim")
        nama = intent.getStringExtra("nama")
        kelas = intent.getStringExtra("kelas")
        nohp = intent.getStringExtra("nohp")

        // Set data ke input field
        nimEdt.setText(nim)
        namaEdt.setText(nama)
        kelasEdt.setText(kelas)
        nohpEdt.setText(nohp)

        updateMahasiswaBtn.setOnClickListener {
            val newNim = nimEdt.text.toString()
            val newNama = namaEdt.text.toString()
            val newKelas = kelasEdt.text.toString()
            val newNohp = nohpEdt.text.toString()

            // Update ke database
            val success = dbHandler.updateMahasiswa(nim!!, newNim, newNama, newKelas, newNohp)

            if (success) {
                Toast.makeText(this, "Mahasiswa telah di-update.", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()  // Tutup activity agar tidak menumpuk di back stack
            } else {
                Toast.makeText(this, "Gagal memperbarui data!", Toast.LENGTH_SHORT).show()
            }
        }

        deleteMahasiswaBtn.setOnClickListener {
            dbHandler.deleteMahasiswa(nim!!)
            Toast.makeText(this@UpdateMahasiswaActivity, "Mahasiswa telah di-Delete..", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@UpdateMahasiswaActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}