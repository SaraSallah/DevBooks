package com.example.storyscope.ui.home

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.storyscope.R
import com.example.storyscope.databinding.FragmentHomeBinding
import com.example.storyscope.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(), BookInteractionListener {
    override val TAG: String = this::class.simpleName.toString()
    override val layoutIdFragment: Int = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()


    override fun setUp() {
        val adapter = BooksAdapter(mutableListOf<BookUiState>(), this)
        binding.rvBook.adapter = adapter
    }

    override fun onClickBook(bookId: Int) {
        Toast.makeText(requireContext(), "heeeey ", Toast.LENGTH_LONG).show()
    }
}