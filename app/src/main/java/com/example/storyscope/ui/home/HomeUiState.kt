package com.example.storyscope.ui.home

import com.example.storyscope.data.remote.model.Book

data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val books : List<BookUiState> = emptyList() ,
    val book: BookUiState = BookUiState(),
)

data class BookUiState(
    val id: String? = "",
    val url: String? = "",
    val image: String? = "",
    val price: String? = "",
    val title: String? = "",
    val subTitle: String? = "",
)

fun Book.toBookUiState(): BookUiState = BookUiState(
    id = isbn13,
    title = title,
    subTitle = subtitle,
    image = image,
    price = price,
    url = url,
)