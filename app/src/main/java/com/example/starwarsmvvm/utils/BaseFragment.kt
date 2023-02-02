package com.example.starwarsmvvm.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.starwarsmvvm.di.StarWarsApp
import com.example.starwarsmvvm.viewmodel.StarWarsViewModel
import javax.inject.Inject

open class BaseFragment : Fragment() {

    @Inject
    lateinit var starWarsViewModelFactory: StarWarsViewModelFactory

    protected val starWarsViewModel: StarWarsViewModel by lazy {
        ViewModelProvider(requireActivity(), starWarsViewModelFactory)[StarWarsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StarWarsApp.starWarsComponent.inject(this)
    }
}