package com.smkth.app4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.smkth.app4.adapter.BookAdapter
import com.smkth.app4.utils.DummyData

import com.smkth.app4.utils.DetailActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val books = DummyData.getBooks()

        val adapter = BookAdapter(books) { book ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("title", book.title)
            intent.putExtra("author", book.author)
            intent.putExtra("year", book.year)
            intent.putExtra("imageRes", book.imageRes)
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
