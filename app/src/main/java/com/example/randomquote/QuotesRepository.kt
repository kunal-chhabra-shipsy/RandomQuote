package com.example.randomquote

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class QuotesRepository(val quotesAPI: QuotesAPI , val quotesDAO: QuotesDAO , val context: Context) {

    private val quotesLiveData  = MutableLiveData<QuotesList>()

    val liveDataToSend : LiveData<QuotesList>
    get() = quotesLiveData


    suspend fun getQuotes(page : Int) : MutableLiveData<QuotesList>{

        if(NetworkingUtils.isNetworkConnected(context)){

            val result = quotesAPI.getQuotes(page)
            if(result.body()!=null){
                quotesLiveData.value = result.body()
                quotesDAO.insertQuotes(result.body()!!.results)
            }
        }

        else{

            val quotes = quotesDAO.getQuotes()
            val quotesList = QuotesList(1,1,1,1,1,quotes)
            quotesLiveData.value = quotesList

        }

        return quotesLiveData
    }
}