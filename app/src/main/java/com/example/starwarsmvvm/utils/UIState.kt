package com.example.starwarsmvvm.utils

sealed class UIState {
    object LOADING : UIState()
    data class SUCCESS<T>(val response: T): UIState()
    data class ERROR(val error: Exception) : UIState()
}
