package com.ozancanguz.booksapp.ui.fragments.bookdetail

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.ozancanguz.booksapp.R
import com.ozancanguz.booksapp.data.db.entities.FavoritesEntity
import com.ozancanguz.booksapp.databinding.FragmentBookDetailBinding
import com.ozancanguz.booksapp.utils.Constants.Companion.loadImage
import com.ozancanguz.booksapp.viewmodels.BookViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_book_detail.*

@AndroidEntryPoint
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


    // create menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.savetofav_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.savetofavmenu){
            saveToFavorites(item)
            Snackbar.make(detailseLayout,"Added to favorites",Snackbar.LENGTH_SHORT)
                .show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saveToFavorites(item: MenuItem) {
        var favoritesEntity=FavoritesEntity(0,bookdetailargs.currentBook)
        bookViewModel.insertFavoriteBooks(favoritesEntity)
        changeMenuItemColor(item,R.color.red)
    }

    private fun changeMenuItemColor(item: MenuItem, color: Int) {
        item.icon?.setTint(ContextCompat.getColor(requireContext(),color))
    }


}