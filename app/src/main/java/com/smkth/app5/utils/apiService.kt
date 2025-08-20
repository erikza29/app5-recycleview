package com.smkth.app5.utils

import com.smkth.app5.model.Book
import retrofit2.Call
import retrofit2.http.GET
interface ApiService {
    @GET("buku")
    fun getBuku(): Call<List<Book>>
}