package com.example.storyscope.ui.home

import com.example.storyscope.R
import com.example.storyscope.ui.base.BaseAdapter
import com.example.storyscope.ui.base.BaseInteractionListener

class BooksAdapter(listener: BookInteractionListener) : BaseAdapter<BookUiState>(listener) {
    override val layoutID: Int = R.layout.item_book
}

interface BookInteractionListener : BaseInteractionListener {
    fun onClickBook(bookId: String)

}