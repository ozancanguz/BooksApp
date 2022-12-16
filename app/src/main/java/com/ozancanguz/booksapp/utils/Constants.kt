package com.ozancanguz.booksapp.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ozancanguz.booksapp.R

class Constants {
    companion object{
        const val BASE_URL="https://api.collectapi.com/book/"

        fun ImageView.loadImage(uri: String?) {
            val options = RequestOptions()

                .error(R.mipmap.ic_launcher)
            Glide.with(context)
                .setDefaultRequestOptions(options)
                .load(uri)
                .into(this)

        }

    }
}