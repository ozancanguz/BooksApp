package com.ozancanguz.booksapp.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ozancanguz.booksapp.data.model.Book

@Entity(tableName = "book_table")

class BookEntity(

    var book:Book
){
    @PrimaryKey(autoGenerate = false)
    var id:Int=0
}