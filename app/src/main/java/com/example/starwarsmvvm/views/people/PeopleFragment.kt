package com.example.starwarsmvvm.views.people

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.starwarsmvvm.databinding.FragmentCommonViewBinding
import com.example.starwarsmvvm.utils.BaseFragment
import com.example.starwarsmvvm.utils.UIState
import com.example.starwarsmvvm.viewmodel.StarWarsViewModel

class PeopleFragment : BaseFragment() {

    private val binding by lazy {
        FragmentCommonViewBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        starWarsViewModel.people.observe(viewLifecycleOwner)  { state ->
            when(state) {
                is UIState.LOADING -> {}
                is UIState.SUCCESS<*> -> {}
                is UIState.ERROR -> {}
            }
        }

        return binding.root
    }
}