package com.example.storyscope.ui.home

import com.example.storyscope.data.repository.StoryScopeRepository
import com.example.storyscope.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val storyScopeRepository: StoryScopeRepository,
) : BaseViewModel<HomeUiState>(HomeUiState()) {
    override val Tag: String = this::class.java.simpleName

    init {
        getNewBooks()

    }

    fun getNewBooks() {
        _state.update { it.copy(isLoading = true, isError = false) }
        tryToExecute(
            { storyScopeRepository.getNewBooks().books!!.map { it!!.toBookUiState() } },
            ::onGetNewBooksSuccess,
            ::onError
        )

    }

    private fun onGetNewBooksSuccess(books: List<BookUiState>) {
        _state.update {
            it.copy(
                isLoading = false,
                books = books
            )
        }
    }

    private fun onError(error: String) {
        _state.update { it.copy(isLoading = false, isError = true) }
    }
}