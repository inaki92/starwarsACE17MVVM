package com.example.starwarsmvvm.views.people

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwarsmvvm.databinding.FragmentCommonViewBinding
import com.example.starwarsmvvm.model.StarWarsResponse
import com.example.starwarsmvvm.utils.BaseFragment
import com.example.starwarsmvvm.utils.UIState
import com.example.starwarsmvvm.viewmodel.StarWarsViewModel
import com.example.starwarsmvvm.views.adapter.StarWarsAdapter

class PeopleFragment : BaseFragment() {

    private val binding by lazy {
        FragmentCommonViewBinding.inflate(layoutInflater)
    }

    private val starWarsAdapter by lazy {
        StarWarsAdapter {
            // todo handle the click to move to the details
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.starWarsRv.apply {
            layoutManager  = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = starWarsAdapter
        }

        starWarsViewModel.people.observe(viewLifecycleOwner)  { state ->
            when(state) {
                is UIState.LOADING -> {}
                is UIState.SUCCESS<StarWarsResponse> -> {
                    starWarsAdapter.updateItems(state.response.results ?: emptyList())
                }
                is UIState.ERROR -> {
                    showError(state.error.localizedMessage) {
                        // todo define an action
                    }
                }
            }
        }

        return binding.root
    }
}