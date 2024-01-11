package com.example.storyscope.data.api

import com.example.storyscope.data.remote.model.BookDetails
import com.example.storyscope.data.remote.model.Books
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BookService {
    @GET("/new")
    suspend fun getNewBooks(): Response<Books>

    @GET("/search/{query}")
    suspend fun searchBooks(@Path("query") query: String): Response<Books>

    @GET("/books/{isbn13}")
    suspend fun getBookDetails(@Path("isbn13") id: String): Response<BookDetails>
}