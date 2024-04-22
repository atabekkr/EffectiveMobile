package com.karsoft.effectivemobile.utils

import android.content.SharedPreferences

class LocalStorage(preference: SharedPreferences) {

    var lastInputCity by StringPreference(preference)

}