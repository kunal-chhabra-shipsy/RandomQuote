package com.example.randomquote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class QuotesViewModel(val quotesRepository: QuotesRepository) : ViewModel() {

    init {
        viewModelScope.launch {
            quotesRepository.getQuotes(1)
        }
    }


    val liveDataToSend: LiveData<QuotesList>
    get() = quotesRepository.liveDataToSend




}