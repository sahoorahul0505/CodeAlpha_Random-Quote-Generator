package com.kodebug.randomquotegenerator.core.common

sealed class AppResults<out T> {
    data class Success<out T>(val data: T) : AppResults<T>()
    data class Error(val exception: Exception) : AppResults<Nothing>()
    object Loading : AppResults<Nothing>()
}