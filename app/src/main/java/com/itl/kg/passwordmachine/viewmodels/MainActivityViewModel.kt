package com.itl.kg.passwordmachine.viewmodels

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.itl.kg.passwordmachine.module.StringBlender


class MainActivityViewModel internal constructor(private val context: Context, private val blender: StringBlender) : ViewModel() {

    private val resultLiveData = MutableLiveData<String>()

    fun getResultLiveData() = resultLiveData as LiveData<String>

    fun convert(input: String) {
        resultLiveData.value = blender.process(input)
    }

    fun copyToClipboard(clipString: String) {
        val clipBoard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("PasswordMachine", clipString)
        clipBoard.setPrimaryClip(clipData)
    }

}