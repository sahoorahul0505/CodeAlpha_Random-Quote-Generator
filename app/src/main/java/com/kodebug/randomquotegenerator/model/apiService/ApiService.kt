package com.kodebug.randomquotegenerator.model.apiService

import com.kodebug.randomquotegenerator.model.data.RandomQuoteResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("random")
    suspend fun getRandomQuote(): Response<RandomQuoteResponse>

}