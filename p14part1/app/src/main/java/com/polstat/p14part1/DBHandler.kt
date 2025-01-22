package com.polstat.p14part1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandler(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {
        private const val DB_NAME = "mahasiswadb"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "mahasiswatbl"
        private const val ID_COL = "id"
        private const val NIM_COL = "nim"
        private const val NAMA_COL = "nama"
        private const val KELAS_COL = "kelas"
        private const val NOHP_COL = "nohp"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val query = "CREATE TABLE $TABLE_NAME (" +
                "$ID_COL INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$NIM_COL TEXT, " +
                "$NAMA_COL TEXT, " +
                "$KELAS_COL TEXT, " +
                "$NOHP_COL TEXT)"
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addNewMahasiswa(nim: String, nama: String, kelas: String, nohp: String) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(NIM_COL, nim)
            put(NAMA_COL, nama)
            put(KELAS_COL, kelas)
            put(NOHP_COL, nohp)
        }
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun readMahasiswa(): ArrayList<MahasiswaModal> {
        val db = readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        val mahasiswaModalArrayList = ArrayList<MahasiswaModal>()
        if (cursor.moveToFirst()) {
            do {
                mahasiswaModalArrayList.add(
                    MahasiswaModal(
                        nim = cursor.getString(1),
                        nama = cursor.getString(2),
                        kelas = cursor.getString(3),
                        nohp = cursor.getString(4)
                    )
                )
            } while (cursor.moveToNext())
        }
        cursor.close()
        return mahasiswaModalArrayList
    }
}
