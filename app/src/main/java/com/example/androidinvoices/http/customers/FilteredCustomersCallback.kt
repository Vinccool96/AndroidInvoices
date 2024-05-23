package com.example.androidinvoices.http.customers

import com.example.androidinvoices.arch.http.HttpCallback
import com.example.androidinvoices.arch.http.HttpClient
import com.example.androidinvoices.arch.http.HttpListener
import com.example.androidinvoices.core.model.FilteredCustomerModel
import com.example.androidinvoices.core.serial.FilteredCustomerSerializer

class FilteredCustomersCallback(private val listener: HttpListener<List<FilteredCustomerModel>>,
        private val http: HttpClient) : HttpCallback<List<FilteredCustomerSerializer>>(false) {

    override fun onSuccess(serialized: List<FilteredCustomerSerializer>) {
        listener.onSuccess(serialized.map { it.toModel() })
    }

    fun execute(filter: String?) {
        add(http.getCustomersFiltered(filter)).enqueue(this)
    }

}