package com.ozancanguz.booksapp.ui.fragments.favorite

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.booksapp.R
import com.ozancanguz.booksapp.adapter.FavoritesAdapter

import com.ozancanguz.booksapp.databinding.FragmentFavoriteBinding
import com.ozancanguz.booksapp.viewmodels.BookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null

    private val binding get() = _binding!!
    private val favoritesAdapter=FavoritesAdapter()
    private val bookViewModel:BookViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val view = binding.root

        // set up rv
           setupRv()

        // update ui
        updateUI()

        // set menu
        setHasOptionsMenu(true)



        return view
    }
    private fun setupRv() {
        binding.favoriteFragmentRV.layoutManager=LinearLayoutManager(requireContext())
        binding.favoriteFragmentRV.adapter=favoritesAdapter

    }

    private fun updateUI() {
         bookViewModel.favoriteBooksList.observe(viewLifecycleOwner, Observer {
             favoritesAdapter.setFavData(it)
         })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.deleteAllIcon){
            // delete all fun will call
        }
        return super.onOptionsItemSelected(item)
    }






}