package com.example.androidinvoices.arch.self

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class SelfShared @Inject constructor(private val context: Context) {

    private val editor: SharedPreferences.Editor
        get() = context.getSharedPreferences(SelfResolver.TAG, Context.MODE_PRIVATE).edit()

    private val prefs = listOf(EMAIL, PASSWORD)

    var email: String
        get() = getPrefs().getString(EMAIL, "")
        set(token) = editor.putString(EMAIL, token).apply()

    var password: String
        get() = getPrefs().getString(PASSWORD, "")
        set(token) = editor.putString(PASSWORD, token).apply()

    private fun getPrefs(): SelfResolver {
        return SelfResolver(context, SelfPreferences.AUTHORITY)
    }


    fun forgetLoggedUser() {
        val edit = editor

        for (str in prefs) {
            edit.remove(str)
        }

        edit.apply()
    }

    companion object {

        private const val EMAIL = "email"

        private const val PASSWORD = "password"

    }
}