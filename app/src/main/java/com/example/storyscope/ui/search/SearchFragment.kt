package com.example.storyscope.ui.search

import androidx.fragment.app.viewModels
import com.example.storyscope.R
import com.example.storyscope.databinding.FragmentSearchBinding
import com.example.storyscope.ui.base.BaseFragment
import com.example.storyscope.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val TAG: String = this::class.simpleName.toString()
    override val layoutIdFragment: Int = R.layout.fragment_search
    override val viewModel: SearchViewModel by viewModels()
    private val searchAdapter by lazy { SearchAdapter(viewModel) }
    override fun setUp() {
        initAdapter()
    }
    private fun initAdapter(){
        binding.rvBook.adapter = searchAdapter

    }

}