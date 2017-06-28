package com.my.hackernooz.services

import android.util.Log
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs

/**
 * Created by my on 6/27/17.
 */

class Http {
    private val HTTP_BASE: String = "https://hacker-news.firebaseio.com/v0"

    fun get(endpoint: String) {
        val fullPath = HTTP_BASE.plus(endpoint)
        fullPath.httpGet().responseString { request, response, result ->
            //do something with response
            when (result) {
                is Result.Failure -> {
                    // error = result.getAs()
                    Log.d("DUDE ERROR", result.toString())
                }
                is Result.Success -> {
                    // data = result.getAs()
                    Log.d("DUDE", result.toString())
                }
            }
        }
    }
}