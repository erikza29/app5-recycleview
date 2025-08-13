package com.smkth.app4.utils

import com.smkth.app4.model.Book
import com.smkth.app4.R

object DummyData {
    fun getBooks(): MutableList<Book> {
        return mutableListOf(
            Book("Laskar Pelangi", "Andrea Hirata", "2005", R.drawable.buku),
            Book("Bumi", "Tere Liye", "2014", R.drawable.buku),
            Book("Negeri 5 Menara", "Ahmad Fuadi", "2009", R.drawable.buku),
            Book("Dilan 1990", "Pidi Baiq", "2014", R.drawable.buku),
            Book("Ayat-Ayat Cinta", "Habiburrahman El Shirazy", "2004", R.drawable.buku)
        )
    }
}
