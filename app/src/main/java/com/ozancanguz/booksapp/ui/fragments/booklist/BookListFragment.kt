package com.ozancanguz.booksapp.ui.fragments.booklist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ozancanguz.booksapp.R
import com.ozancanguz.booksapp.databinding.FragmentBookListBinding
import com.ozancanguz.booksapp.viewmodels.BookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookListFragment : Fragment() {
    private var _binding: FragmentBookListBinding? = null

    private val binding get() = _binding!!
    private val bookViewModel:BookViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookListBinding.inflate(inflater, container, false)
        val view = binding.root

        observeLiveData()

        return view
    }

    private fun observeLiveData() {
        bookViewModel.requestSafeCallAllBooks()
        bookViewModel.booksList.observe(viewLifecycleOwner, Observer {
            Log.d("listfragment","" +it.result)
        })
    }


}