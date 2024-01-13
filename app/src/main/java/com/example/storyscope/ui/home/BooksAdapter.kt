package com.example.storyscope.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.storyscope.R
import com.example.storyscope.databinding.ItemBookBinding

class BooksAdapter(private var items: List<BookUiState>,
                   private val listener: BookInteractionListener)
    : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        return BooksViewHolder(LayoutInflater.from(parent.context).
        inflate(R.layout.item_book,parent,false))
    }

    override fun getItemCount(): Int =items.size

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val currentItem = items[position]
        holder.binding.item = currentItem
        holder.binding.listener = listener
    }
    fun setItems(newList :  List<BookUiState>){
        items = newList
    }
    class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemBookBinding.bind(itemView)
    }
}
interface BookInteractionListener {
    fun onClickBook(bookId : Int)

}