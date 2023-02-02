package com.example.starwarsmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarsmvvm.model.domain.People
import com.example.starwarsmvvm.rest.StarWarsRepository
import com.example.starwarsmvvm.utils.UIState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StarWarsViewModel(
    private val starWarsRepository: StarWarsRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    init {
        getPeople()
        getPlanets()
        getStarships()
    }

    var fragmentState: Boolean = false

    private val _people: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val people: LiveData<UIState> get() = _people

    private val _peopleDetails: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val peopleDetails: LiveData<UIState> get() = _peopleDetails

    private val _planets: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val planets: LiveData<UIState> get() = _planets

    private val _planetDetails: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val planetDetails: LiveData<UIState> get() = _planetDetails

    private val _starships: MutableStateFlow<UIState> = MutableStateFlow(UIState.LOADING)
    val starships: StateFlow<UIState> get() = _starships

    private val _starshipDetails: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val starshipDetails: LiveData<UIState> get() = _starshipDetails

    fun getPeople(id: String? = null) {
        id?.let {
            viewModelScope.launch(ioDispatcher) {
                starWarsRepository.getPeopleById(it).collect {
                    _peopleDetails.postValue(it)
                }
            }
        } ?: run {
            viewModelScope.launch(ioDispatcher) {
                starWarsRepository.getAllPeople().collect {
                    _people.postValue(it)
                }
            }
        }
    }

    fun getPlanets(id: String? = null) {
        id?.let {
            viewModelScope.launch(ioDispatcher) {
                starWarsRepository.getPlanetById(it).collect {
                    _planetDetails.postValue(it)
                }
            }
        } ?: run {
            viewModelScope.launch(ioDispatcher) {
                starWarsRepository.getPlanets().collect {
                    _planets.postValue(it)
                }
            }
        }
    }

    fun getStarships(id: String? = null) {
        id?.let {
            viewModelScope.launch(ioDispatcher) {
                starWarsRepository.getStarShipById(it).collect {
                    _starshipDetails.postValue(it)
                }
            }
        } ?: run {
            viewModelScope.launch(ioDispatcher) {
                starWarsRepository.getStarships().collect {
                    _starshipDetails.postValue(it)
                }
            }
        }
    }
}