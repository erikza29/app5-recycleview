package com.smkth.app4.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.smkth.app4.model.Book
import com.smkth.app4.R

class BookAdapter(
    private val books: MutableList<Book>,
    private val onClick: (Book) -> Unit
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivBook: ImageView = view.findViewById(R.id.ivBook)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvAuthor: TextView = view.findViewById(R.id.tvAuthor)
        val tvYear: TextView = view.findViewById(R.id.tvYear)
        val btnDelete: ImageButton = view.findViewById(R.id.btnDelete)

        fun bind(book: Book) {
            ivBook.setImageResource(book.imageRes)
            tvTitle.text = book.title
            tvAuthor.text = book.author
            tvYear.text = book.year

            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "Pilih: ${book.title}", Toast.LENGTH_SHORT).show()
                onClick(book)
            }

            btnDelete.setOnClickListener {
                AlertDialog.Builder(itemView.context)
                    .setTitle("Konfirmasi")
                    .setMessage("Hapus buku ini?")
                    .setPositiveButton("Ya") { _, _ ->
                        books.removeAt(adapterPosition)
                        notifyItemRemoved(adapterPosition)
                    }
                    .setNegativeButton("Batal", null)
                    .show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int = books.size
}
