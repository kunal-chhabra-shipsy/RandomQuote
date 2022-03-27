package com.example.randomquote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: QuotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quotesAPI : QuotesAPI = RetrofitHelper.getInstance().create(QuotesAPI::class.java)
        val quotesDao : QuotesDAO = QuotesDatabase.getDatabase(applicationContext).getQuotesDao()
        val repository : QuotesRepository = QuotesRepository(quotesAPI , quotesDao , this)

        viewModel = ViewModelProvider(this , QuotesViewModelFactory(repository)).get(QuotesViewModel::class.java)

        viewModel.liveDataToSend.observe(this , Observer {
//            Log.v("CHHABRA" , it.toString())

            Toast.makeText(this , it.results.size.toString() , Toast.LENGTH_SHORT).show()
        })
    }
}