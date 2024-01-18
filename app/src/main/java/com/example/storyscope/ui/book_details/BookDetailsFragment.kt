package com.example.storyscope.ui.book_details

import androidx.fragment.app.viewModels
import com.example.storyscope.R
import com.example.storyscope.databinding.FragmentBookDetailsBinding
import com.example.storyscope.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookDetailsFragment : BaseFragment<FragmentBookDetailsBinding>() {

    override val TAG: String = this::class.java.simpleName
    override val layoutIdFragment: Int = R.layout.fragment_book_details
    override val viewModel: BookDetailsViewModel by viewModels()

}