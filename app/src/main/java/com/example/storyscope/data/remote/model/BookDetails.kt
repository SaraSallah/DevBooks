package com.example.storyscope.data.remote.model


import com.google.gson.annotations.SerializedName

data class BookDetails(
    @SerializedName("authors")
    val authors: String? = null,
    @SerializedName("desc")
    val desc: String? = null,
    @SerializedName("error")
    val error: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("isbn10")
    val isbn10: String? = null,
    @SerializedName("isbn13")
    val isbn13: String? = null,
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("pages")
    val pages: String? = null,
    @SerializedName("pdf")
    val pdf: List<String>? = null,
    @SerializedName("price")
    val price: String? = null,
    @SerializedName("publisher")
    val publisher: String? = null,
    @SerializedName("rating")
    val rating: String? = null,
    @SerializedName("subtitle")
    val subtitle: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("year")
    val year: String? = null
)