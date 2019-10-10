package com.example.kotlindemo.dagger.component

import android.app.Application
import com.example.kotlindemo.BaseApplication
import com.example.kotlindemo.dagger.module.ActivityBuildersModule
import com.example.kotlindemo.dagger.module.AppModule
import com.example.kotlindemo.dagger.module.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component (modules = [AndroidSupportInjectionModule::class,ActivityBuildersModule::class,AppModule::class,ViewModelFactoryModule::class])
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application:Application): Builder

        fun build(): AppComponent
    }
}