package com.example.storyscope.ui.book_details

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.viewModels
import com.example.storyscope.R
import com.example.storyscope.databinding.FragmentBookDetailsBinding
import com.example.storyscope.ui.base.BaseFragment
import com.example.storyscope.ui.collect
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookDetailsFragment : BaseFragment<FragmentBookDetailsBinding>() {

    override val TAG: String = this::class.java.simpleName
    override val layoutIdFragment: Int = R.layout.fragment_book_details
    override val viewModel: BookDetailsViewModel by viewModels()
    override fun setUp() {
        collectEffect()
    }

    private fun collectEffect() {
        collect(viewModel.effect) { effect ->
            effect.getContentIfHandled()?.let {
                openBrowser(it)
            }
        }

    }

    private fun openBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        requireContext().startActivity(intent)

    }

}