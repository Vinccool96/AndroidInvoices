package com.example.androidinvoices.http.revenue

import com.example.androidinvoices.arch.http.HttpCallback
import com.example.androidinvoices.arch.http.HttpClient
import com.example.androidinvoices.arch.http.HttpListener
import com.example.androidinvoices.core.model.RevenueModel
import com.example.androidinvoices.core.serial.RevenueSerializer

class RevenuesCallback(private val listener: HttpListener<List<RevenueModel>>, private val http: HttpClient) :
        HttpCallback<List<RevenueSerializer>>(false) {

    override fun onSuccess(serialized: List<RevenueSerializer>) {
        listener.onSuccess(serialized.map { it.toModel() })
    }

    fun execute() {
        add(http.getRevenues()).enqueue(this)
    }

}