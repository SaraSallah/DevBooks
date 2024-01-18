package com.example.storyscope.ui.book_details

import androidx.lifecycle.SavedStateHandle
import com.example.storyscope.data.repository.StoryScopeRepository
import com.example.storyscope.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject
@HiltViewModel
class BookDetailsViewModel @Inject constructor(
    private val repository: StoryScopeRepository,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<BookDetailsScreenUiState, Int>(BookDetailsScreenUiState()) {

    override val Tag: String = this::class.java.simpleName
    private val args =
        BookDetailsFragmentArgs.fromSavedStateHandle(savedStateHandle)

    init {
        getBookDetails(args.bookId)
    }

    private fun getBookDetails(bookId: String) {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { repository.getBookDetails(bookId).toBookDetailsUiState() },
            ::onGetBookDetailsSuccess,
            ::onGetBookDetailsError
        )
    }

    private fun onGetBookDetailsSuccess(book: BookDetailsUiState) {
        _state.update { it.copy(isLoading = false, bookDetails = book) }
    }

    private fun onGetBookDetailsError(error: String) {
        _state.update { it.copy(isError = true, isLoading = false) }
    }
}