package com.ozancanguz.booksapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ozancanguz.booksapp.data.db.entities.BookEntity

@Database(
    entities = [BookEntity::class],
    version = 1,
    exportSchema = false,
)

@TypeConverters(TypeConverter::class)
abstract class BooksDatabase: RoomDatabase() {

    abstract fun bookDao():BookDao

}