package com.polstat.p14part2

import retrofit2.Call
import retrofit2.http.*

interface BookApiService {
    @GET("/books")
    fun getBooks(): Call<List<Book>>

    @GET("/books/{id}")
    fun getBookById(@Path("id") id: Int): Call<Book>

    @POST("/books")
    fun createBook(@Body book: Book): Call<Book>

    @PUT("/books/{id}")
    fun updateBook(@Path("id") id: Int, @Body book: Book): Call<Book>

    @DELETE("/books/{id}")
    fun deleteBook(@Path("id") id: Int): Call<Void>
}
