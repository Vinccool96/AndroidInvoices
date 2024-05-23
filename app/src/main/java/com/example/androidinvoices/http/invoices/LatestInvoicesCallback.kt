package com.example.androidinvoices.http.invoices

import com.example.androidinvoices.arch.http.HttpCallback
import com.example.androidinvoices.arch.http.HttpClient
import com.example.androidinvoices.arch.http.HttpListener
import com.example.androidinvoices.core.model.InvoiceModel
import com.example.androidinvoices.core.serial.InvoiceSerializer

class LatestInvoicesCallback(private val listener: HttpListener<List<InvoiceModel>>, private val http: HttpClient) : HttpCallback<List<InvoiceSerializer>>(false) {

    override fun onSuccess(serialized: List<InvoiceSerializer>) {
        listener.onSuccess(serialized.map { it.toModel() })
    }

    fun execute() {
        add(http.getLatestInvoices()).enqueue(this)
    }

}