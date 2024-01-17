package com.example.storyscope.ui.home

import androidx.lifecycle.viewModelScope
import com.example.storyscope.data.repository.StoryScopeRepository
import com.example.storyscope.ui.base.BaseViewModel
import com.example.storyscope.utils.EventHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val storyScopeRepository: StoryScopeRepository,
) : BaseViewModel<HomeUiState, HomeUiEffect>(HomeUiState()), BookInteractionListener {
    override val Tag: String = this::class.java.simpleName

    init {
        getNewBooks()

    }

    private fun getNewBooks() {
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

    override fun onClickBook(bookId: String) {
        viewModelScope.launch {
            _effect.emit(EventHandler(HomeUiEffect.ClickBookUiEffect(bookId)))
        }
    }
    fun onClickSearch() {
        viewModelScope.launch {
            _effect.emit(EventHandler(HomeUiEffect.ClickSearchUiEffect))
        }


}
}

