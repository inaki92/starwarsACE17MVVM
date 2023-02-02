package com.example.starwarsmvvm.utils

sealed class UIState {
    object LOADING : UIState()
    //  todo add the success state after domain data created
    data class ERROR(val error: Exception) : UIState()
}
