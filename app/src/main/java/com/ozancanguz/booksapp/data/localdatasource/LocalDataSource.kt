package com.ozancanguz.booksapp.data.localdatasource

import com.ozancanguz.booksapp.data.db.BookDao
import com.ozancanguz.booksapp.data.db.entities.BookEntity
import com.ozancanguz.booksapp.data.model.Book
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class LocalDataSource@Inject constructor(private val bookDao: BookDao) {


   fun readAllBooks(): Flow<List<BookEntity>> {
       return bookDao.readAllBoooks()
    }


    suspend fun insertBook(bookEntity: BookEntity){
        return bookDao.insertBook(bookEntity)
    }


}