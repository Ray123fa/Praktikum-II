package com.polstat.p14part1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MahasiswaRVAdapter(
    private val mahasiswaList: ArrayList<MahasiswaModal>,
    private val context: Context
) : RecyclerView.Adapter<MahasiswaRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.mahasiswa_rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modal = mahasiswaList[position]
        holder.nimTV.text = modal.nim
        holder.namaTV.text = modal.nama
        holder.kelasTV.text = modal.kelas
        holder.nohpTV.text = modal.nohp

        holder.itemView.setOnClickListener {
            val intent = Intent(context, UpdateMahasiswaActivity::class.java).apply {
                putExtra("nim", modal.nim)
                putExtra("nama", modal.nama)
                putExtra("kelas", modal.kelas)
                putExtra("nohp", modal.nohp)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = mahasiswaList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nimTV: TextView = itemView.findViewById(R.id.nimTextView)
        val namaTV: TextView = itemView.findViewById(R.id.namaTextView)
        val kelasTV: TextView = itemView.findViewById(R.id.kelasTextView)
        val nohpTV: TextView = itemView.findViewById(R.id.nohpTextView)
    }
}