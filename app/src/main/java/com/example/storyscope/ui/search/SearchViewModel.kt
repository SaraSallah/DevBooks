package com.example.storyscope.ui.search

import com.example.storyscope.data.repository.StoryScopeRepository
import com.example.storyscope.ui.base.BaseViewModel
import com.example.storyscope.ui.home.BookUiState
import com.example.storyscope.ui.home.toBookUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: StoryScopeRepository
) : BaseViewModel<SearchUiState, SearchUiEffect>(SearchUiState()),SearchInteractionListener {

    override val Tag: String = this::class.java.simpleName

    fun searchForBooks(query : String){
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { repository.searchForBooks(query).books!!.map { it!!.toBookUiState() } },
            ::onGetSearchedBooksSuccess,
            ::onGetSearchedBooksError
        )
    }
    private fun onGetSearchedBooksSuccess(books : List<BookUiState>) {
        _state.update {
            it.copy(
                isLoading = false,
                books = books
            )
        }
    }

    private fun onGetSearchedBooksError(error : String){
        _state.update { it.copy(isLoading = false , isError = true) }
    }

    override fun onClickBook(bookId: String) {
        TODO("Not yet implemented")
    }

}