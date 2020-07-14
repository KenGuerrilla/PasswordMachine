package com.itl.kg.passwordmachine.utilities

import android.app.Activity
import android.util.DisplayMetrics
import android.view.inputmethod.InputMethodManager

/**
 *
 * Created by kenguerrilla on 2020/6/4.
 *
 */

fun hideKeyboard(activity: Activity?) {
    val imm = activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    val currentView = activity.currentFocus
    imm.hideSoftInputFromWindow(currentView?.windowToken, 0)
}