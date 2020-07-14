package com.itl.kg.passwordmachine.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.itl.kg.passwordmachine.module.StringBlender


class MainActivityViewModelFactory(private val context: Context, private val blender: StringBlender) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(context, blender) as T
    }
}