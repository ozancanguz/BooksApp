package com.ozancanguz.booksapp.ui.fragments.bookdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ozancanguz.booksapp.R
import com.ozancanguz.booksapp.databinding.FragmentBookDetailBinding
import com.ozancanguz.booksapp.utils.Constants.Companion.loadImage


class BookDetail : Fragment() {
    private var _binding: FragmentBookDetailBinding? = null


    private val bookdetailargs:BookDetailArgs by navArgs()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookDetailBinding.inflate(inflater, container, false)
        val view = binding.root

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


}