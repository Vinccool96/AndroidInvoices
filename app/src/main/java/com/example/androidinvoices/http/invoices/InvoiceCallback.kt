package com.example.androidinvoices.http.invoices

import com.example.androidinvoices.arch.http.HttpCallback
import com.example.androidinvoices.arch.http.HttpClient
import com.example.androidinvoices.arch.http.HttpListener
import com.example.androidinvoices.core.model.InvoiceMinimalModel
import com.example.androidinvoices.core.serial.InvoiceMinimalSerializer

class InvoiceCallback(private val listener: HttpListener<InvoiceMinimalModel>, private val http: HttpClient) :
        HttpCallback<InvoiceMinimalSerializer>(false) {

    override fun onSuccess(serialized: InvoiceMinimalSerializer) {
        listener.onSuccess(serialized.toModel())
    }

    fun execute(id: String) {
        add(http.getInvoice(id)).enqueue(this)
    }

}