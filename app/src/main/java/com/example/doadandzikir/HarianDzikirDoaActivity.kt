package com.example.doadandzikir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HarianDzikirDoaActivity : AppCompatActivity() {

    private val listDzikir : ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_harian_dzikir_doa)

        val rvDzikirHarian = findViewById<RecyclerView>(R.id.rv_dzikir_doa_harian)
        rvDzikirHarian.layoutManager = LinearLayoutManager (this)
        rvDzikirHarian.adapter = DzikirDoaAdapter(listDzikir)
        initData()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initData(){
        val desc = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val lafalz = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val terjemahan = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        for (data in desc.indices){
            val dzikir = DzikirDoa(
                desc[data],
                lafalz[data],
                terjemahan[data]
            )
            listDzikir.add(dzikir)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}