package com.example.storyscope.utils

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.storyscope.R
import com.example.storyscope.ui.base.BaseAdapter

//@BindingAdapter(value = ["app:imageUrl"])
//fun setImageFromUrl(view: ImageView, url: String?) {
//    Glide.with(view)
//        .load(url)
//        .placeholder(R.drawable.book_place_holder)
//        .centerCrop()
//        .into(view)
//}
@BindingAdapter("app:imageUrl")
fun setImageFromUrl(view: ImageView, url: String?) {
    if (url.isNullOrEmpty()) {
        view.visibility = View.GONE
    } else {
        Glide.with(view)
            .load(url)
            .placeholder(R.drawable.book_place_holder)
            .centerCrop()
            .into(view)
    }
}

@BindingAdapter(value = ["app:hideIfLoading", "app:hideWhenError"], requireAll = false)
fun hideContentScreen(view: View, hideIfLoading: Boolean?, hideWhenError: Boolean?) {
    view.visibility = when {
        hideIfLoading == true || hideWhenError == true -> View.GONE
        else -> View.VISIBLE
    }

}


@BindingAdapter("app:hideIfLoading")
fun hideIfLoading(view: View, condition: Boolean) {
    view.isVisible = !condition
}

@BindingAdapter(value = ["app:hideWhenError"])
fun hideWhenError(view: View, condition: Boolean) {
    view.isVisible = !condition
}

@BindingAdapter(value = ["app:showUIWhenCondition"])
fun showUIWhenCondition(view: View, state: Boolean) {
    view.isVisible = state
}

@BindingAdapter(value = ["app:showWhenLoading"])
fun showWhenLoading(view: View, state: Boolean) {
    if (state)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}

@BindingAdapter(value = ["app:showWhenError"])
fun showWhenError(view: View, condition: Boolean) {
    view.isVisible = condition
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    (view.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())


}

@BindingAdapter("app:showIfNotEmpty")
fun <T> showIfNotEmpty(view: View, items: List<T>) {
    view.isVisible = items.isNotEmpty()
}

@BindingAdapter(value = ["app:hideWhenSearch", "app:hideWhenNotFound"])
fun <T> hideWhenSearch(view: View, query: String?, list: List<T>?) {
    if (query.orEmpty().isEmpty() || list == null) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.INVISIBLE
    }
}
@BindingAdapter(value = ["app:showIfEmpty", "app:hideWhenEmptyQuery"])
fun <T> setPlaceHolder(view: View, list: List<T>?, query: String?) {
    if (list == null || query!!.isEmpty()) view.visibility = View.INVISIBLE
    else if (list.isEmpty()) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.INVISIBLE
    }
}

