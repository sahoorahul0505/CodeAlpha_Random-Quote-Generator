package com.kodebug.randomquotegenerator.viewModel

import com.kodebug.randomquotegenerator.model.data.RandomQuoteResponse

data class QuoteState(
    val data : RandomQuoteResponse? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
