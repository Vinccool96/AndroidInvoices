package com.example.androidinvoices.arch.http

import android.util.Base64
import com.example.androidinvoices.arch.self.SelfShared
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class HttpBuilder {

    fun build(self: SelfShared): OkHttpClient {
        return OkHttpClient.Builder().apply {

            addInterceptor {
                it.proceed(it.request().newBuilder().addHeader(HEAD, auth(self)).build())
            }

            connectTimeout(2, TimeUnit.MINUTES)
            readTimeout(2, TimeUnit.MINUTES)
            writeTimeout(2, TimeUnit.MINUTES)
        }.build()
    }

    private fun auth(self: SelfShared): String {
        val email = self.email
        val password = self.password
        val stringToEncode = "$email:$password"
        val bytesToEncode = stringToEncode.encodeToByteArray()
        val encoded = Base64.encode(bytesToEncode, Base64.DEFAULT).decodeToString()
        return "Basic $encoded"
    }

    companion object {

        private const val HEAD = "Authorization"

    }

}