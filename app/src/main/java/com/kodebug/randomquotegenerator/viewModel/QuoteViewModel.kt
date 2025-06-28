package com.kodebug.randomquotegenerator.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kodebug.randomquotegenerator.core.common.AppResults
import com.kodebug.randomquotegenerator.model.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuoteViewModel @Inject constructor(private val quoteRepository: QuoteRepository) : ViewModel() {

    private val _quoteState = MutableStateFlow(QuoteState())
    val quoteState = _quoteState.asStateFlow()

    init {
        getRandomQuote()
    }

    fun getRandomQuote() {
        viewModelScope.launch {
            quoteRepository.getRandomQuote().collect {
                when (it) {
                    AppResults.Loading -> {
                        _quoteState.value = QuoteState(isLoading = true)
                    }

                    is AppResults.Error -> {
                        _quoteState.value = QuoteState(error = it.exception.message.toString())
                    }

                    is AppResults.Success -> {
                        _quoteState.value = QuoteState(data = it.data.body())
                    }
                }
            }
        }
    }
}