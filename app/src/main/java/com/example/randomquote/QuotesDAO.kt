package com.example.randomquote

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuotesDAO {

    @Query("SELECT * FROM quotesTable")
    suspend fun getQuotes() : List<Results>

    @Insert
    suspend fun insertQuotes(quotesList : List<Results>)

}