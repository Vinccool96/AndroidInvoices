package com.example.androidinvoices.http.invoices

import com.example.androidinvoices.arch.http.HttpCallback
import com.example.androidinvoices.arch.http.HttpClient
import com.example.androidinvoices.arch.http.HttpErrorListener
import com.example.androidinvoices.core.model.InvoiceModel
import com.example.androidinvoices.core.model.UpdateInvoiceModel
import com.example.androidinvoices.core.serial.InvoiceSerializer
import com.example.androidinvoices.core.serial.UpdateInvoiceSerializer

class UpdateInvoiceCallback(private val listener: HttpErrorListener<InvoiceModel>, private val http: HttpClient) :
        HttpCallback<InvoiceSerializer>(false) {

    override fun onSuccess(serialized: InvoiceSerializer) {
        listener.onSuccess(serialized.toModel())
    }

    override fun onError(code: Int) {
        listener.onError(code)
    }

    fun execute(id: String, model: UpdateInvoiceModel) {
        add(http.updateInvoice(id, UpdateInvoiceSerializer.fromModel(model)))
    }

}