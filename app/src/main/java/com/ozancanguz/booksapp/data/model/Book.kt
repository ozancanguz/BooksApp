package com.ozancanguz.booksapp.data.model


import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("result")
    val result: List<Result>,

)