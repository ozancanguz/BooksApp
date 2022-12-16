package com.ozancanguz.booksapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ozancanguz.booksapp.data.db.entities.BookEntity
import com.ozancanguz.booksapp.data.model.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {


    // read from db
    @Query("select *from book_table order by id asc")
    fun readAllBoooks(): Flow<List<BookEntity>>

    // insert database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(bookEntity: BookEntity)



}