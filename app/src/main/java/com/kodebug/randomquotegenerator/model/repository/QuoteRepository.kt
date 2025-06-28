package com.kodebug.randomquotegenerator.model.repository

import com.kodebug.randomquotegenerator.core.common.AppResults
import com.kodebug.randomquotegenerator.model.apiService.ApiService
import com.kodebug.randomquotegenerator.model.data.RandomQuoteResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val apiService: ApiService) {

    fun getRandomQuote() : Flow<AppResults<Response<RandomQuoteResponse>>> = flow{
        emit(AppResults.Loading)
        try {
            val response = apiService.getRandomQuote()
            emit(AppResults.Success(response))
        } catch (e: Exception) {
            emit(AppResults.Error(e))
        }
    }
}