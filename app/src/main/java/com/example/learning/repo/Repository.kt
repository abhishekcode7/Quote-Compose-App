package com.example.learning.repo

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.learning.api.QuoteApi
import com.example.learning.models.QuoteData
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class Repository @Inject constructor(private val quoteApi: QuoteApi) {

    private val _philosophers = MutableStateFlow<List<String>>(emptyList())
    val philosophers = _philosophers

    private val _quotes = MutableStateFlow<List<QuoteData>>(emptyList())
    val quotes = _quotes

    suspend fun getPhilosophers() {
        val res = quoteApi.getPhilosophers()
        if (res.isSuccessful && res.body() != null) {
            _philosophers.emit(res.body()!!)
        }
    }

    suspend fun getQuotes(name: String) {
        val res = quoteApi.getQuotes("\$..data[?(@.name==\"$name\")]")
        if (res.isSuccessful && res.body() != null) {
            _quotes.emit(res.body()!!)
        }
    }
}