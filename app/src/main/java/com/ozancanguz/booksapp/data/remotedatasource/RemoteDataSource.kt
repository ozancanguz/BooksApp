package com.ozancanguz.booksapp.data.remotedatasource

import com.ozancanguz.booksapp.data.bookapiservice.BooksApi
import com.ozancanguz.booksapp.data.model.Book
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Response
import javax.inject.Inject


class RemoteDataSource@Inject constructor(private val booksApi: BooksApi){

    suspend fun getAllBooks(): Response<Book> {
        return booksApi.getAllBooks()
    }

}