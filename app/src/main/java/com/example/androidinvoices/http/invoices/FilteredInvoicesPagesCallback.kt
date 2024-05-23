package com.example.androidinvoices.http.invoices

import com.example.androidinvoices.arch.http.HttpCallback
import com.example.androidinvoices.arch.http.HttpClient
import com.example.androidinvoices.arch.http.HttpListener

class FilteredInvoicesPagesCallback(private val listener: HttpListener<Int>, private val http: HttpClient) :
        HttpCallback<Int>(false) {

    override fun onSuccess(serialized: Int) {
        listener.onSuccess(serialized)
    }

    fun execute(filter: String?) {
        add(http.getInvoicesFilteredPage(filter)).enqueue(this)
    }

}