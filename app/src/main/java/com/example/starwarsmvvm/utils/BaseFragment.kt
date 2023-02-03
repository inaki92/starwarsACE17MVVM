package com.example.starwarsmvvm.utils

import android.app.AlertDialog
import android.content.DialogInterface
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

    protected fun showError(message: String, action: () -> Unit)  {
        AlertDialog.Builder(requireActivity())
            .setTitle("Error Occurred")
            .setMessage(message)
            .setPositiveButton("RETRY") { dialog, _ ->
                action()
                dialog.dismiss()
            }
            .setNegativeButton("DISMISS") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
}