package com.example.androidinvoices.http.invoices

import com.example.androidinvoices.arch.http.HttpCallback
import com.example.androidinvoices.arch.http.HttpClient
import com.example.androidinvoices.arch.http.HttpErrorListener
import com.example.androidinvoices.core.model.CreateInvoiceModel
import com.example.androidinvoices.core.model.InvoiceModel
import com.example.androidinvoices.core.serial.CreateInvoiceSerializer
import com.example.androidinvoices.core.serial.InvoiceSerializer

class CreateInvoiceCallback(private val listener: HttpErrorListener<InvoiceModel>, private val http: HttpClient) :
        HttpCallback<InvoiceSerializer>(false) {

    override fun onSuccess(serialized: InvoiceSerializer) {
        listener.onSuccess(serialized.toModel())
    }

    override fun onError(code: Int) {
        listener.onError(code)
    }

    fun execute(model: CreateInvoiceModel) {
        add(http.createInvoice(CreateInvoiceSerializer.fromModel(model))).enqueue(this)
    }

}