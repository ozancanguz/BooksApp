package com.ozancanguz.booksapp.ui.fragments.booklist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.booksapp.R
import com.ozancanguz.booksapp.adapter.BooksAdapter
import com.ozancanguz.booksapp.databinding.FragmentBookListBinding
import com.ozancanguz.booksapp.viewmodels.BookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookListFragment : Fragment() {
    private var _binding: FragmentBookListBinding? = null

    private val binding get() = _binding!!
    private val bookViewModel:BookViewModel by viewModels()
    private var bookAdapter=BooksAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookListBinding.inflate(inflater, container, false)
        val view = binding.root

        // setup rv
        setupRv()

        // set up data and update ui
        observeLiveData()

        return view
    }

    private fun setupRv() {
         binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerView.adapter=bookAdapter
    }

    private fun observeLiveData() {
        bookViewModel.requestSafeCallAllBooks()
        bookViewModel.booksList.observe(viewLifecycleOwner, Observer { book ->
         //   Log.d("listfragment","" +it.result)

            bookAdapter.setData(book)


        })
    }


}