package com.ozancanguz.booksapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.booksapp.R
import com.ozancanguz.booksapp.data.model.Book
import com.ozancanguz.booksapp.data.model.Result
import com.ozancanguz.booksapp.ui.fragments.booklist.BookListFragmentDirections
import com.ozancanguz.booksapp.utils.Constants.Companion.loadImage
import kotlinx.android.synthetic.main.book_row_layout.view.*


class BooksAdapter:RecyclerView.Adapter<BooksAdapter.BookViewHolder>(){

    var bookList= emptyList<Result>()

    fun setData(newData: Book){
        this.bookList=newData.result
        notifyDataSetChanged()
    }

    class BookViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.book_row_layout,parent,false)
        return  BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
       var currentBook=bookList[position]
        holder.itemView.books_img.loadImage(currentBook.image)
        holder.itemView.books_title.text=currentBook.title
        holder.itemView.books_price.text=currentBook.fiyat

        holder.itemView.setOnClickListener {
            val direction=BookListFragmentDirections.actionBookListFragmentToBookDetail(currentBook)
            holder.itemView.findNavController().navigate(direction)

        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }


}