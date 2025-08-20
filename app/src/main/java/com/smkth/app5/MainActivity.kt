package com.smkth.app5

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smkth.app5.adapter.BukuAdapter
import com.smkth.app5.model.Book
import com.smkth.app5.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var rvBook: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBook = findViewById(R.id.rvbook)
        rvBook.layoutManager = LinearLayoutManager(this)

        // Panggil API
        RetrofitClient.instance.getBuku().enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                if (response.isSuccessful) {
                    val list = response.body() ?: emptyList()
                    rvBook.adapter = BukuAdapter(list)
                } else {
                    Toast.makeText(this@MainActivity, "Response error: ${response.code()}", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Gagal: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}
