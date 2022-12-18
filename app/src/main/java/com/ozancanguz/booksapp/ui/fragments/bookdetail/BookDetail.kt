package com.ozancanguz.booksapp.ui.fragments.bookdetail

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ozancanguz.booksapp.R
import com.ozancanguz.booksapp.databinding.FragmentBookDetailBinding
import com.ozancanguz.booksapp.utils.Constants.Companion.loadImage
import com.ozancanguz.booksapp.viewmodels.BookViewModel


class BookDetail : Fragment() {
    private var _binding: FragmentBookDetailBinding? = null


    private val bookdetailargs:BookDetailArgs by navArgs()

    private val binding get() = _binding!!

    private val bookViewModel:BookViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookDetailBinding.inflate(inflater, container, false)
        val view = binding.root

        setHasOptionsMenu(true)
        updateUI()

        return view
    }

    private fun updateUI() {
        binding.detailsImage.loadImage(bookdetailargs.currentBook.image)
        binding.detailsIndirim.text=bookdetailargs.currentBook.indirim
        binding.detailsTitle.text=bookdetailargs.currentBook.title
        binding.detailsYazar.text=bookdetailargs.currentBook.yazar
        binding.detailsYayin.text=bookdetailargs.currentBook.yayin
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.savetofav_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }



}