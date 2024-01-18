package com.example.storyscope.ui.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storyscope.utils.EventHandler
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<T,E>(initialState: T) : ViewModel() {
    abstract val Tag: String
    protected open fun log(message: Any) =
        Log.e(Tag, message.toString())

    protected val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    protected val _effect = MutableSharedFlow<EventHandler<E>>()
    val effect = _effect.asSharedFlow()


    protected fun <T>tryToExecute(
        function: suspend () -> T,
        onSuccess: (T) -> Unit,
        onError: (errorMessage: String) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                val result = function()
                log("tryToExecute: $result")
                onSuccess(result)
            } catch (e: Exception) {
                log("onError : ${e.message}")
                onError(e.message.toString())


            }
        }
    }


}