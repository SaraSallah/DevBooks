package com.example.storyscope.data.repository

import com.example.storyscope.data.api.DevBookServices
import com.example.storyscope.data.remote.model.BookDetails
import com.example.storyscope.data.remote.model.Books
import retrofit2.Response
import javax.inject.Inject

class DevBooksRepository @Inject constructor(
    private val api: DevBookServices,
) {
    suspend fun getNewBooks(): Books = wrap { api.getNewBooks() }
    suspend fun searchForBooks(query: String): Books = wrap { api.searchForBooks(query) }
    suspend fun getBookDetails(bookId: String): BookDetails = wrap { api.getBookDetails(bookId) }

    private suspend fun <T : Any> wrap(function: suspend () -> Response<T>): T {
        val response = function()
        return if (response.isSuccessful)
            response.body() ?: throw Throwable("Response body is null")
        else
            throw Throwable("Request failed with status code ${response.code()}")

    }

}