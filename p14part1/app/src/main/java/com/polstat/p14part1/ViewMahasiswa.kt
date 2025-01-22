package com.polstat.p14part1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewMahasiswa : AppCompatActivity() {

    private lateinit var mahasiswaModalArrayList: ArrayList<MahasiswaModal>
    private lateinit var dbHandler: DBHandler
    private lateinit var mahasiswaRVAdapter: MahasiswaRVAdapter
    private lateinit var mahasiswaRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_mahasiswa)

        mahasiswaModalArrayList = ArrayList()
        dbHandler = DBHandler(this)
        mahasiswaModalArrayList = dbHandler.readMahasiswa()

        mahasiswaRVAdapter = MahasiswaRVAdapter(mahasiswaModalArrayList, this)
        mahasiswaRV = findViewById(R.id.idRVMahasiswa)

        mahasiswaRV.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mahasiswaRV.adapter = mahasiswaRVAdapter
    }
}