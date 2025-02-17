package com.example.learning.api

import com.example.learning.models.QuoteData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface QuoteApi {

    @GET("/v3/b/67b0511eacd3cb34a8e2f5de?meta=false")
    suspend fun getQuotes(@Header("X-JSON-Path") name:String):Response<List<QuoteData>>

    @GET("/v3/b/67b0511eacd3cb34a8e2f5de?meta=false")
    @Headers("X-JSON-Path:$..name")
    suspend fun getPhilosophers():Response<List<String>>
}