package com.example.storyscope.ui.search

import com.example.storyscope.R
import com.example.storyscope.ui.base.BaseAdapter
import com.example.storyscope.ui.base.BaseInteractionListener
import com.example.storyscope.ui.home.BookUiState

class SearchAdapter(listener: BaseInteractionListener):BaseAdapter<BookUiState>(listener) {
    override val layoutID: Int  = R.layout.item_book_search
}
interface SearchInteractionListener : BaseInteractionListener{
    fun onClickBook(bookId : String)
}