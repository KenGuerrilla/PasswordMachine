package com.itl.kg.passwordmachine.utilities

import android.app.Activity
import android.view.inputmethod.InputMethodManager

fun hideKeyboard(activity: Activity?) {
    val imm = activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    val currentView = activity.currentFocus
    imm.hideSoftInputFromWindow(currentView?.windowToken, 0)
}