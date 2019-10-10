package com.example.kotlindemo.dagger.module

import android.arch.lifecycle.ViewModelProvider
import com.example.kotlindemo.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
     abstract fun bindViewModelFactory (viewModelProviderFactory: ViewModelProviderFactory):ViewModelProvider.Factory

}