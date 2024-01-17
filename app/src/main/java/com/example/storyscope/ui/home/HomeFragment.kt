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
    override val TAG: String = this::class.simpleName.toString()
    override val layoutIdFragment: Int = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()


    override fun setUp() {
       initAdapter()
        collectActions()

    }

    private fun initAdapter() {
        val adapter = BooksAdapter(mutableListOf(), viewModel)
        binding.rvBook.adapter = adapter

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
        findNavController().navigate(bookId)

    }



}