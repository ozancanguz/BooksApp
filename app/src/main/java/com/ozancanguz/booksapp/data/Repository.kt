package com.ozancanguz.booksapp.data

import com.ozancanguz.booksapp.data.remotedatasource.RemoteDataSource
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repository@Inject constructor(remoteDataSource: RemoteDataSource){


    val remote=remoteDataSource

}