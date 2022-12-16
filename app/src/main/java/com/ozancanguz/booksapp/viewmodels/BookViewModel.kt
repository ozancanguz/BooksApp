package com.ozancanguz.booksapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.ozancanguz.booksapp.data.Repository
import com.ozancanguz.booksapp.data.db.entities.BookEntity
import com.ozancanguz.booksapp.data.model.Book
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BookViewModel@Inject constructor(private val repository: Repository,
                                       application: Application):AndroidViewModel(application){

   //      --------------- for retrofit -----------
          var booksList=MutableLiveData<Book>()
          var job: Job?=null


    // -------------for room-----------
      var readbookList: LiveData<List<BookEntity>> = repository.local.readAllBooks().asLiveData()


    // insert books fun

    fun insertBook(bookEntity: BookEntity){
        viewModelScope.launch {
            repository.local.insertBook(bookEntity)
        }
    }

    fun saveToDb(book: Book){
        val bookEntity=BookEntity(book)
        insertBook(bookEntity)
    }


  //  ---------------------------- for retrofit -------------
    fun requestAllBooks(){
        job= CoroutineScope(Dispatchers.IO).launch {
            val response=repository.remote.getAllBooks()
            if(response.isSuccessful){
                booksList.postValue(response.body())

                val books=booksList.value!!
                 saveToDb(books)


            }else{
                Log.d("booksviewmodel","data not found")
            }
        }
    }


}