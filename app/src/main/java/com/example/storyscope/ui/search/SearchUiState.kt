package com.example.storyscope.ui.search

import com.example.storyscope.ui.home.BookUiState

data class SearchUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val books: List<BookUiState> = emptyList(),
    val query : String = "",
)