package com.example.starwarsmvvm.di

import android.content.BroadcastReceiver
import androidx.fragment.app.Fragment
import com.example.starwarsmvvm.MainActivity
import com.example.starwarsmvvm.utils.BaseFragment
import dagger.Component

@Component(modules = [
    NetworkModule::class,
    RepositoryModule::class,
    ApplicationModule::class
])
interface StarWarsComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(baseFragment: BaseFragment)

//    fun inject(fragment: Fragment)
//    fun inject(fragment: Fragment)
//    fun inject(fragment: Fragment)
//    fun inject(service: Service)
//    fun inject(broadcastReceiver: BroadcastReceiver)
}