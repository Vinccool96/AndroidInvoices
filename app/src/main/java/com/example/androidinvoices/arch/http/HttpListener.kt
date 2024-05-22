package com.example.androidinvoices.arch.http

interface HttpListener<T> {

    fun onSuccess(body: T)

}