package com.smkth.app5

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvJudul: TextView = findViewById(R.id.tvJudulDetail)
        val tvPenulis: TextView = findViewById(R.id.tvPenulisDetail)
        val tvTahun: TextView = findViewById(R.id.tvTahunDetail)
        val ivCover: ImageView = findViewById(R.id.ivCoverDetail)

        // Ambil data dari intent
        val judul = intent.getStringExtra("judul")
        val penulis = intent.getStringExtra("penulis")
        val tahun = intent.getStringExtra("tahun")
        val cover = intent.getStringExtra("cover")

        // Set ke view
        tvJudul.text = judul
        tvPenulis.text = penulis
        tvTahun.text = tahun

        Glide.with(this)
            .load(cover)
            .into(ivCover)
    }
}
