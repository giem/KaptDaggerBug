package com.example.kaptdaggerbug.di

import com.example.kaptdaggerbug.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

}