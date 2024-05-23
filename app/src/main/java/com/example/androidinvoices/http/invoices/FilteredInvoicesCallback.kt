package com.example.androidinvoices.http.invoices

import com.example.androidinvoices.arch.http.HttpCallback
import com.example.androidinvoices.arch.http.HttpClient
import com.example.androidinvoices.arch.http.HttpListener
import com.example.androidinvoices.core.model.InvoiceModel
import com.example.androidinvoices.core.serial.InvoiceSerializer

class FilteredInvoicesCallback(private val listener: HttpListener<List<InvoiceModel>>, private val http: HttpClient) :
        HttpCallback<List<InvoiceSerializer>>(false) {

    override fun onSuccess(serialized: List<InvoiceSerializer>) {
        listener.onSuccess(serialized.map { it.toModel() })
    }

    fun execute(filter: String?, page: Int?) {
        add(http.getInvoicesFiltered(filter, page)).enqueue(this)
    }

}