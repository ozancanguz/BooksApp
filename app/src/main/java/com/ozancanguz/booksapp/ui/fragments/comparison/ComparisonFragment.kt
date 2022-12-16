package com.ozancanguz.booksapp.ui.fragments.comparison

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozancanguz.booksapp.R
import com.ozancanguz.booksapp.databinding.FragmentBookListBinding
import com.ozancanguz.booksapp.databinding.FragmentComparisonBinding


class ComparisonFragment : Fragment() {
    private var _binding: FragmentComparisonBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentComparisonBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }


}