package com.example.androidinvoices.arch.http

import android.content.Context
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class HttpCallback<T> : HttpArray(), Callback<T> {

    override fun onFailure(call: Call<T>, t: Throwable) {
        fail(call, t)
    }

    fun enqueue(call: Call<T>): Call<T> {
        return call.also { call.enqueue(this) }
    }

    fun error(code: Int, message: String) {
        Log.d(TAG, "Error: $code")
        exception(Exception(message))
    }

    fun exception(throwable: Throwable) {
        Log.e(TAG, "Error: ${throwable.message}")
        Log.e(TAG, "Error: ${throwable.cause}")
        Log.e(TAG, "Error: ${throwable.localizedMessage}")
        throwable.printStackTrace()
    }

    fun fail(call: Call<T>, throwable: Throwable?) {
        if (call.isCanceled) {
            Log.e(TAG, "HttpClient did not receive request")
        }

        throwable?.let { exception(it) }
    }

    fun successful() {
        Log.d(TAG, SUCCESS)
    }

    open fun hasErrors(response: Response<*>): Boolean {
        val hasErrors = response.errorBody() != null

        if (hasErrors) {
            Log.d(TAG, response.code().toString())
        }

        return hasErrors
    }

    open fun isSuccessful(response: Response<*>, isVoid: Boolean): Boolean {
        if (hasErrors(response)) {
            error(response.code(), response.message())
        } else if (response.isSuccessful && isVoid == (response.body() == null)) {
            successful()
            return true
        }

        return false
    }

    protected fun toast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    companion object {

        private val TAG = HttpCallback::class.java.simpleName

        private const val SUCCESS = "Transfer is successful"

    }

}