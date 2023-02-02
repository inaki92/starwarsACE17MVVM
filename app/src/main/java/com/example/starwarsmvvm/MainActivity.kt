package com.example.starwarsmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.starwarsmvvm.databinding.ActivityMainBinding
import com.example.starwarsmvvm.di.StarWarsApp

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        StarWarsApp.starWarsComponent.inject(this)

        val hostFragment =
            supportFragmentManager.findFragmentById(R.id.frag_container) as NavHostFragment

        binding.navigationBottom.setupWithNavController(hostFragment.navController)
    }
}