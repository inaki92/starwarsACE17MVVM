package com.example.starwarsmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarsmvvm.model.StarWarsResponse
import com.example.starwarsmvvm.model.domain.People
import com.example.starwarsmvvm.model.domain.Planet
import com.example.starwarsmvvm.model.domain.Starship
import com.example.starwarsmvvm.rest.StarWarsRepository
import com.example.starwarsmvvm.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarWarsViewModel @Inject constructor(
    private val starWarsRepository: StarWarsRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    init {
        getPeople()
        getPlanets()
        getStarships()
    }

    var fragmentState: Boolean = false

    private val _people: MutableLiveData<UIState<StarWarsResponse>> = MutableLiveData(UIState.LOADING)
    val people: LiveData<UIState<StarWarsResponse>> get() = _people

    private val _peopleDetails: MutableLiveData<UIState<People>> = MutableLiveData(UIState.LOADING)
    val peopleDetails: LiveData<UIState<People>> get() = _peopleDetails

    private val _planets: MutableLiveData<UIState<StarWarsResponse>> = MutableLiveData(UIState.LOADING)
    val planets: LiveData<UIState<StarWarsResponse>> get() = _planets

    private val _planetDetails: MutableLiveData<UIState<Planet>> = MutableLiveData(UIState.LOADING)
    val planetDetails: LiveData<UIState<Planet>> get() = _planetDetails

    private val _starships: MutableStateFlow<UIState<StarWarsResponse>> = MutableStateFlow(UIState.LOADING)
    val starships: StateFlow<UIState<StarWarsResponse>> get() = _starships

    private val _starshipDetails: MutableLiveData<UIState<Starship>> = MutableLiveData(UIState.LOADING)
    val starshipDetails: LiveData<UIState<Starship>> get() = _starshipDetails

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
                    _starships.value = it
                }
            }
        }
    }
}