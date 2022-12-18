package com.ozancanguz.booksapp.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ozancanguz.booksapp.data.model.Book
import com.ozancanguz.booksapp.data.model.Result

class TypeConverter {


        var gson = Gson()

        @androidx.room.TypeConverter
        fun BooksToString(book: Book): String {
            return gson.toJson(book)
        }

        @androidx.room.TypeConverter
        fun stringToBooks(data: String): Book {
            val listType = object : TypeToken<Book>() {}.type
            return gson.fromJson(data, listType)
        }

    @TypeConverter
    fun resultToString(result: com.ozancanguz.booksapp.data.model.Result):String{
        return gson.toJson(result)
    }

    @TypeConverter
    fun stringToResult(data:String):com.ozancanguz.booksapp.data.model.Result{
        val listType=object : TypeToken <Result>(){
        }.type
        return gson.fromJson(data,listType)
    }


}