package com.example.androidinvoices.arch.http

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call

abstract class HttpArray {

    open val calls = ArrayList<Call<*>>()

    inline fun <reified R> add(call: Call<R>): Call<R> {
        return call.also { calls.add(it) }
    }

    protected fun finalize() {
        for (call in calls) {
            call.cancel()
        }
    }

    fun isJSONValid(test: String): Boolean {
        try {
            JSONObject(test)
        } catch (_: JSONException) {
            try {
                JSONArray(test)
            } catch (_: JSONException) {
                return false
            }
        }

        return true
    }

}