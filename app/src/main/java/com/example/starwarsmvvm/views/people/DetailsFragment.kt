package com.example.starwarsmvvm.views.people

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starwarsmvvm.R
import com.example.starwarsmvvm.databinding.FragmentDetailsBinding
import com.example.starwarsmvvm.utils.BaseFragment
import com.example.starwarsmvvm.utils.UIState

class DetailsFragment : BaseFragment() {

    private val binding by lazy {
        FragmentDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        starWarsViewModel.peopleDetails.observe(viewLifecycleOwner) { state ->
            when(state) {
                is UIState.LOADING -> {}
                is UIState.SUCCESS<*> -> {}
                is UIState.ERROR -> {}
            }
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        if (!starWarsViewModel.fragmentState) {
            starWarsViewModel.getPeople("")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        starWarsViewModel.fragmentState = true
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        starWarsViewModel.fragmentState = false
    }
}