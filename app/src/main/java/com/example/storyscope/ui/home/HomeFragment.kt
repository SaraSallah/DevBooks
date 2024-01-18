package com.example.storyscope.ui.home

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.storyscope.R
import com.example.storyscope.databinding.FragmentHomeBinding
import com.example.storyscope.ui.base.BaseFragment
import com.example.storyscope.ui.collect
import com.example.storyscope.ui.home.HomeUiEffect.ClickBookUiEffect
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val TAG: String = this::class.java.simpleName
    override val layoutIdFragment: Int = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()
    private val booksAdapter : BooksAdapter by lazy {BooksAdapter(viewModel)  }

    override fun setUp() {
       initAdapter()
        collectActions()

    }

    private fun initAdapter() {
        binding.rvBook.adapter = booksAdapter

    }
    private fun collectActions(){
        collect(viewModel.effect){effect->
            effect.getContentIfHandled()?.let { onEffect(it) }
        }
    }

    private fun onEffect(effect: HomeUiEffect) {
        when(effect){
            is HomeUiEffect.ClickSearchUiEffect -> navigateToSearch()
            is ClickBookUiEffect -> navigateToBookDetails(effect.id)
        }

    }

    private fun navigateToSearch(){
        val action =HomeFragmentDirections.actionHomeFragmentToSearchFragment()
        findNavController().navigate(action)

    }
    private fun navigateToBookDetails(bookId : String){
        val action =HomeFragmentDirections.actionHomeFragmentToBookDetailsFragment(bookId)
        findNavController().navigate(action)

    }



}