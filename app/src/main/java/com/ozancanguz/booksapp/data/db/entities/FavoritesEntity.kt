package com.ozancanguz.booksapp.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ozancanguz.booksapp.data.model.Result


@Entity(tableName = "favorites_table")
class FavoritesEntity(

    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var result:Result

){





}