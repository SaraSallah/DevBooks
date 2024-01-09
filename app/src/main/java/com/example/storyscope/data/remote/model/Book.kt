package com.example.storyscope.data.remote.model


import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("isbn13")
    val isbn13: String? = null,
    @SerializedName("price")
    val price: String? = null,
    @SerializedName("subtitle")
    val subtitle: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("url")
    val url: String? = null
)