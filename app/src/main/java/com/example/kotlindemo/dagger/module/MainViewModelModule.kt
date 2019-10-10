package com.example.kotlindemo.dagger.module

import android.arch.lifecycle.ViewModel
import com.example.kotlindemo.dagger.component.ViewModelKey
import com.example.kotlindemo.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
     abstract fun bindMainViewModel(mainViewModel: MainViewModel):ViewModel

    // if there is more than viewmodel in the project, we just add it here
}