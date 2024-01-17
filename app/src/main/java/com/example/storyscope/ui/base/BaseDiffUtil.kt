package com.example.storyscope.ui.base

import androidx.recyclerview.widget.DiffUtil

class BaseDiffUtil<T>(
    private val oldList: List<T>,
    private val newList: List<T>,
    private val checkIsSameItem: (oldList: T, newItem: T) -> Boolean,
    private val checkISameContent: (oldList: T, newList: T) -> Boolean,
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return checkIsSameItem(oldList[oldItemPosition], newList[newItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return checkISameContent(oldList[oldItemPosition], newList[newItemPosition])
    }

}