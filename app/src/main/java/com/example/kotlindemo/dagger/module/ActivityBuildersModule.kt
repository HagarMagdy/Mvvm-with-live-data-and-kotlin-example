package com.example.kotlindemo.dagger.module

import com.example.kotlindemo.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
        (modules = [MainViewModelModule::class, MainActivityModule::class])
    abstract fun ContributeMainActivity(): MainActivity
}