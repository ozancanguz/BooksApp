package com.ozancanguz.booksapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.booksapp.R
import com.ozancanguz.booksapp.data.db.entities.FavoritesEntity
import com.ozancanguz.booksapp.data.model.Result
import com.ozancanguz.booksapp.ui.fragments.favorite.FavoriteFragmentArgs
import com.ozancanguz.booksapp.ui.fragments.favorite.FavoriteFragmentDirections
import com.ozancanguz.booksapp.utils.Constants.Companion.loadImage
import kotlinx.android.synthetic.main.favorite_row_lyout.view.*

class FavoritesAdapter:RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>(){

    var favoriteList= emptyList<FavoritesEntity>()

    fun setFavData(newData:List<FavoritesEntity>){
        this.favoriteList=newData
        notifyDataSetChanged()
    }

    class FavoritesViewHolder(view: View):RecyclerView.ViewHolder(view) {




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.favorite_row_lyout,parent,false)
        return FavoritesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        var currentFavBook=favoriteList[position]
        holder.itemView.favorites_img.loadImage(currentFavBook.result.image)
        holder.itemView.favorites_title.text=currentFavBook.result.title
        holder.itemView.favorites_price.text=currentFavBook.result.fiyat

        holder.itemView.favRV.setOnClickListener {
            var action=FavoriteFragmentDirections.actionFavoriteFragmentToBookDetail(currentFavBook.result)
            holder.itemView.findNavController().navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return favoriteList.size
    }

}