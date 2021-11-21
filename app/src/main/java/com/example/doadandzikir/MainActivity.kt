package com.example.doadandzikir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {


    private val listArtikel : ArrayList<Artikel> = arrayListOf()
    private lateinit var dotSlider : Array<ImageView?>

    //Cara Buat TODO        =>SLIDER<=
    private val slidingCallback = object  : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            for (i in 0 until listArtikel.size){
                dotSlider[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext,R.drawable.do_inactive)
                )
            }
            dotSlider[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext,R.drawable.do_active)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initData()
        setUpViewPager()

    }

    private fun setUpViewPager() {
        val llSliderDots : LinearLayout = findViewById(R.id.ll_slider_dot)

        dotSlider = arrayOfNulls(listArtikel.size)

        for (i in 0 until listArtikel.size){
            dotSlider[i] = ImageView(this)
            dotSlider[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.do_inactive
                )
            )

            //Mengatur jarak antar indicator
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            //Mengatur jarak antar indicator
            params.setMargins(9,0,9,0)
            //Mengatur Posisi Indicator
            params.gravity = Gravity.CENTER_VERTICAL
            //Menerapkan params sebagai aturan bagaimana indicator di tampilkan
            llSliderDots.addView(dotSlider[i],params)
        }
    }

    private fun initData () {
        val titleArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val descArtikel = resources.getStringArray(R.array.arr_desc_artikel)
        val imgArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)

        for (data in titleArtikel.indices){
            val artikel = Artikel(
                titleArtikel[data],
                descArtikel[data],
                imgArtikel.getResourceId(data,10)
            )
            listArtikel.add(artikel)
        }
        imgArtikel.recycle()
    }

    private fun initView() {
        //Menampilkan TODO Slider
        val vpArtikel :ViewPager2 = findViewById(R.id.vp_artikel)
        vpArtikel.adapter = ArtikelAdapter(listArtikel)
        //registerOnPageChangeCallback untuk TODO Menanmpilkan indicator para view pager
        vpArtikel.registerOnPageChangeCallback(slidingCallback)

        val llDzikirDoaShalat : LinearLayout = findViewById(R.id.ll_dzikir_doa_shalat)
        llDzikirDoaShalat.setOnClickListener {
            startActivity(Intent(this, QauliyahShalatActivity::class.java))
        }

        val llDzikirSetiapSaat = findViewById<LinearLayout>(R.id.ll_dzikir_setiap_saat)
        llDzikirSetiapSaat.setOnClickListener {
            startActivity(Intent(this, SetiapSaatDzikirActivity::class.java))
        }
        val llDzikirDoaHarian : LinearLayout = findViewById(R.id.ll_dzikir_doa_harian)
        llDzikirDoaHarian.setOnClickListener {
            startActivity(Intent(this, HarianDzikirDoaActivity::class.java))
        }
        val llDzikirPagiPetang : LinearLayout = findViewById(R.id.ll_dzikir_pagi_petang)
        llDzikirPagiPetang.setOnClickListener {
            startActivity(Intent(this, PagiPetangDzikirActivity::class.java))
        }
    }

}