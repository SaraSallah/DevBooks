package com.example.storyscope.utils

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.storyscope.R
import com.example.storyscope.data.remote.model.Book
import com.example.storyscope.ui.home.BookUiState
import com.example.storyscope.ui.home.BooksAdapter

@BindingAdapter(value = ["app:imageUrl"])
fun setImageFromUrl(view: ImageView, url: String?) {
    Glide.with(view)
        .load(url)
        .placeholder(R.drawable.book_place_holder)
        .error(R.drawable.book_place_holder)
        .centerCrop()
        .into(view)
}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun showWhenSuccess(view: View, state: Boolean) {
    if (state)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}

@BindingAdapter(value = ["app:showWhenLoading"])
fun showWhenLoading(view: View, state: Boolean) {
    if (state)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}

@BindingAdapter(value = ["app:showWhenError"])
fun showWhenError(view: View, state: Boolean) {
    if (state)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}

@BindingAdapter(value = ["app:items"])
fun setRecyclerItems(view: RecyclerView, items: List<BookUiState>?) {
    if (items != null)
        (view.adapter as BooksAdapter?)?.setItems(items)
    else
        (view.adapter as BooksAdapter?)?.setItems(emptyList())
}
@BindingAdapter("app:showIfNotEmpty")
fun <T> showIfNotEmpty(view: View, items: List<T>) {
    view.isVisible = items.isNotEmpty()
}
