package com.example.doadandzikir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.cardview.widget.CardView

class PagiPetangDzikirActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagi_petang_dzikir)

        val cvDzikirPagi : CardView = findViewById(R.id.cv_dzikir_pagi)
        cvDzikirPagi.setOnClickListener(this)

        val btnDzikirPagi : ImageButton = findViewById(R.id.btn_dzikir_pagi)
        btnDzikirPagi.setOnClickListener(this)

        val cvDzikirPetang : CardView = findViewById(R.id.cv_dzikir_petang)
        cvDzikirPetang.setOnClickListener(this)

        val btnDzikirPetang : ImageButton = findViewById(R.id.btn_dzikir_petang)
        btnDzikirPetang.setOnClickListener(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.cv_dzikir_pagi -> startActivity(Intent(this, DzikirPagiActivity::class.java))
            R.id.btn_dzikir_pagi -> startActivity(Intent(this, DzikirPagiActivity::class.java))

            R.id.cv_dzikir_petang -> startActivity(Intent(this, DzikirPagiActivity::class.java))
            R.id.btn_dzikir_petang -> startActivity(Intent(this, DzikirPagiActivity::class.java))
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}