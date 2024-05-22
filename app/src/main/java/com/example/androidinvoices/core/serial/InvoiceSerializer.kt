package com.example.androidinvoices.core.serial

import com.example.androidinvoices.core.model.InvoiceModel
import com.example.androidinvoices.core.model.Status
import com.example.androidinvoices.core.serial.adapter.DateAdapter
import com.example.androidinvoices.core.serial.adapter.StatusAdapter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.JsonAdapter
import java.util.Date

class InvoiceSerializer(@Expose var id: String = "", @Expose var customer: CustomerSerializer = CustomerSerializer(),
        @Expose var customerId: String = "", @Expose var amount: Int = Int.MIN_VALUE,
        @Expose @JsonAdapter(StatusAdapter::class) var status: Status = Status.PENDING,
        @Expose @JsonAdapter(DateAdapter::class) var date: Date = Date()) {

    fun toModel(): InvoiceModel {
        return InvoiceModel(id, customer.toModel(), customerId, amount, status, date)
    }

}