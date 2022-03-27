package com.example.randomquote

import android.content.Context
import android.net.ConnectivityManager

class NetworkingUtils {

    companion object {

    public fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return cm!!.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    }
}
}