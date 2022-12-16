package com.ozancanguz.booksapp.data.model


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("fiyat")
    val fiyat: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("indirim")
    val indirim: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("yayın")
    val yayin: String,
    @SerializedName("yazar")
    val yazar: String
)