package com.example.starwarsmvvm.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.starwarsmvvm.rest.StarWarsRepository
import com.example.starwarsmvvm.viewmodel.StarWarsViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class StarWarsViewModelFactory @Inject constructor(
    private val starWarsRepository: StarWarsRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StarWarsViewModel(starWarsRepository, ioDispatcher) as T
    }
}