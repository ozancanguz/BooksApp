package com.ozancanguz.booksapp.data.bookapiservice

import com.ozancanguz.booksapp.data.model.Book
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface BooksApi {

    @Headers(
        "authorization: apikey 2xAW88zA1iemGAxzWMNumI:47IyS3uICCasjqzWaFtxnn",
        "content-type: application/json"
    )
    @GET("newBook")
    suspend fun getAllBooks(): Response<Book>


}