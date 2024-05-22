package com.example.androidinvoices.arch.http

interface HttpErrorListener<T> : HttpListener<T> {

    fun onError(code: Int)

}