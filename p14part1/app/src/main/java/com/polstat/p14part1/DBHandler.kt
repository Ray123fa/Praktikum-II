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
        val query = """CREATE TABLE $TABLE_NAME (
            $ID_COL INTEGER PRIMARY KEY AUTOINCREMENT, 
            $NIM_COL TEXT UNIQUE, 
            $NAMA_COL TEXT, 
            $KELAS_COL TEXT, 
            $NOHP_COL TEXT)"""
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addNewMahasiswa(nim: String, nama: String, kelas: String, nohp: String): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(NIM_COL, nim)
            put(NAMA_COL, nama)
            put(KELAS_COL, kelas)
            put(NOHP_COL, nohp)
        }

        val success = db.insert(TABLE_NAME, null, values) != -1L
        db.close()
        return success
    }

    fun readMahasiswa(): ArrayList<MahasiswaModal> {
        val mahasiswaList = ArrayList<MahasiswaModal>()
        val db = readableDatabase
        val cursor: Cursor? = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        cursor?.use {
            if (it.moveToFirst()) {
                do {
                    val mahasiswa = MahasiswaModal(
                        it.getString(it.getColumnIndexOrThrow(NIM_COL)),
                        it.getString(it.getColumnIndexOrThrow(NAMA_COL)),
                        it.getString(it.getColumnIndexOrThrow(KELAS_COL)),
                        it.getString(it.getColumnIndexOrThrow(NOHP_COL))
                    )
                    mahasiswaList.add(mahasiswa)
                } while (it.moveToNext())
            }
        }

        cursor?.close()
        return mahasiswaList
    }

    fun updateMahasiswa(originalNim: String, nim: String, nama: String, kelas: String, nohp: String): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(NIM_COL, nim)
            put(NAMA_COL, nama)
            put(KELAS_COL, kelas)
            put(NOHP_COL, nohp)
        }

        val success = db.update(TABLE_NAME, values, "$NIM_COL=?", arrayOf(originalNim)) > 0
        db.close()
        return success
    }

    fun deleteMahasiswa(nim: String) {
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "nim=?", arrayOf(nim))
        db.close()
    }
}
