package com.example.kotlindemo.viewmodel

import android.arch.lifecycle.ViewModel
import javax.inject.Inject
import android.arch.lifecycle.ViewModelProvider
import android.util.Log
import javax.inject.Provider
import javax.inject.Singleton


class ViewModelProviderFactory @Inject
constructor( private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) { // if the viewmodel has not been created

            // loop through the allowable keys (aka allowed classes with the @ViewModelKey)
            for ((key, value) in creators) {

                // if it's allowed, set the Provider<ViewModel>
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }

        // if this is not one of the allowed keys, throw exception
        if (creator == null) {
            Log.i("DebugTag","creator == null")

            throw IllegalArgumentException("unknown model class $modelClass")
        }

        // return the Provider
        try {
            Log.i("DebugTag","try")

            return creator!!.get() as T
        } catch (e: Exception) {
            Log.i("DebugTag","catch")
            Log.i("DebugTag","error is ${e.localizedMessage}")

            throw RuntimeException(e)
        }

    }

    companion object {

        private val TAG = "ViewModelProviderFactor"
    }
}

