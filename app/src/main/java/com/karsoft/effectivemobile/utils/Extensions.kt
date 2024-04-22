package com.karsoft.effectivemobile.utils

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.snackbar(string: String) {
    Snackbar.make(this.requireView(), string, Snackbar.LENGTH_SHORT).show()
}