package com.example.storyscope.ui.book_details

import com.example.storyscope.data.remote.model.BookDetails

data class BookDetailsScreenUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val bookDetails: BookDetailsUiState = BookDetailsUiState(),
)

data class BookDetailsUiState(
    val id: String? = "",
    val title: String? = "",
    val subTitle: String? = "",
    val url: String? = "",
    val price: String? = "",
    val image: String? = "",
    val rating: Int? = 0,
    val year: String? = "",
    val pages: String? = "",
    val language: String? = "",
    val publisher: String? = "",
    val pdf: Map<String, String>? = emptyMap(),
    val authors: String? = "",
    val description: String? = "",
)

fun BookDetails.toBookDetailsUiState(): BookDetailsUiState = BookDetailsUiState(
    id = isbn13,
    title = title,
    subTitle = subtitle,
    url = url,
    price = price,
    image = image,
    rating = rating?.rateToInteger(rating),
    year = year,
    pages = pages,
    language = language,
    publisher = publisher,
    pdf = pdf,
    authors = authors,
    description = desc
)
fun String.rateToInteger(rate: String):Int
= rate.toInt()
