package com.ozancanguz.booksapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ozancanguz.booksapp.data.db.entities.BookEntity
import com.ozancanguz.booksapp.data.db.entities.FavoritesEntity

@Database(
    entities = [BookEntity::class,FavoritesEntity::class],
    version = 1,
    exportSchema = false,
)

@TypeConverters(TypeConverter::class)
abstract class BooksDatabase: RoomDatabase() {

    abstract fun bookDao():BookDao

}