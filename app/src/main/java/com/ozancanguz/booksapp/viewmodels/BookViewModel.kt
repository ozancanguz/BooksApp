package com.ozancanguz.booksapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ozancanguz.booksapp.data.Repository
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


          var booksList=MutableLiveData<Book>()
          var job: Job?=null

    fun requestSafeCallAllBooks(){
        requestAllBooks()
    }

    fun requestAllBooks(){
        job= CoroutineScope(Dispatchers.IO).launch {
            val response=repository.remote.getAllBooks()
            if(response.isSuccessful){
                booksList.postValue(response.body())
            }else{
                Log.d("booksviewmodel","data not found")
            }
        }
    }


}