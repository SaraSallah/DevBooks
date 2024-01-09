package com.example.storyscope.data.remote.model


import com.google.gson.annotations.SerializedName

data class Books(
    @SerializedName("books")
    val books: List<Book?>? = null,
    @SerializedName("error")
    val error: String? = null,
    @SerializedName("total")
    val total: String? = null
)