package com.smkth.app4.utils

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smkth.app4.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail) // harus dipanggil sebelum findViewById

        // HARUS di dalam onCreate
        val ivBook = findViewById<ImageView>(R.id.ivBook)
        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val tvAuthor = findViewById<TextView>(R.id.tvAuthor)
        val tvYear = findViewById<TextView>(R.id.tvYear)

        val title = intent.getStringExtra("title")
        val author = intent.getStringExtra("author")
        val year = intent.getStringExtra("year")
        val imageRes = intent.getIntExtra("imageRes", 0)

        ivBook.setImageResource(imageRes)
        tvTitle.text = title
        tvAuthor.text = author
        tvYear.text = year
    }
}
