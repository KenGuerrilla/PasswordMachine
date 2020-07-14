package com.itl.kg.passwordmachine.utilities

import android.content.Context
import com.itl.kg.passwordmachine.module.StringBlender
import com.itl.kg.passwordmachine.viewmodels.MainActivityViewModelFactory


object InjectorUtils {

    fun provideMainActivityViewModelFactory(context: Context): MainActivityViewModelFactory {
        val blender = StringBlender()
        return MainActivityViewModelFactory(context, blender)
    }

}