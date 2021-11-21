package com.example.doadandzikir

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DzikirDoaAdapter (private val listDzikirDoa : ArrayList<DzikirDoa>) : RecyclerView.Adapter<DzikirDoaAdapter.MyViewHolder>(){

    inner class MyViewHolder (view: View): RecyclerView.ViewHolder(view){
            //Inisialisasi view dari layout row_item_dzikir.xml
        val tvDesc : TextView = view.findViewById(R.id.tv_desc)
        val tvLafaz : TextView = view.findViewById(R.id.tv_lafaz)
        val tvTerjemahan : TextView = view.findViewById(R.id.tv_terjemahan)
    }

            //Menampilkan data sesuai dengan posisi layout yang di tentukan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
    LayoutInflater.from(parent.context).inflate(R.layout.row_item_dzikir_doa, parent,false))


        //Menampilkan data menjadi sebuah tampilan
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.tvDesc.text = listDzikirDoa[position].desc
            holder.tvLafaz.text = listDzikirDoa[position].lafaz
            holder.tvTerjemahan.text = listDzikirDoa[position].terjemah
    }
        //Menentukan Jumlah Data Yang Di Tampilkan
    override fun getItemCount(): Int = listDzikirDoa.size
}