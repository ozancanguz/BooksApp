package com.ozancanguz.booksapp.ui.fragments.bookdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozancanguz.booksapp.R
import com.ozancanguz.booksapp.databinding.FragmentBookDetailBinding


class BookDetail : Fragment() {
    private var _binding: FragmentBookDetailBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


}