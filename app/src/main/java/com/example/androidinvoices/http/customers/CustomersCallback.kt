package com.example.androidinvoices.http.customers

import com.example.androidinvoices.arch.http.HttpCallback
import com.example.androidinvoices.arch.http.HttpClient
import com.example.androidinvoices.arch.http.HttpListener
import com.example.androidinvoices.core.model.CustomerMinimalModel
import com.example.androidinvoices.core.serial.CustomerMinimalSerializer

class CustomersCallback(private val listener: HttpListener<List<CustomerMinimalModel>>, private val http: HttpClient) :
        HttpCallback<List<CustomerMinimalSerializer>>(false) {

    override fun onSuccess(serialized: List<CustomerMinimalSerializer>) {
        listener.onSuccess(serialized.map { it.toModel() })
    }

    fun execute() {
        add(http.getCustomers()).enqueue(this)
    }

}