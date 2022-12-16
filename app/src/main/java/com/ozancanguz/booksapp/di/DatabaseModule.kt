package com.ozancanguz.booksapp.di

import android.content.Context
import androidx.room.Room
import com.ozancanguz.booksapp.data.db.BooksDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        BooksDatabase::class.java,
        "books_database"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: BooksDatabase) = database.bookDao()

}
