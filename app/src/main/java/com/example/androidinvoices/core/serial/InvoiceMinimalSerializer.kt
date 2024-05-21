package com.example.androidinvoices.core.serial

import com.example.androidinvoices.core.model.Status
import com.example.androidinvoices.core.serial.adapter.StatusAdapter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.JsonAdapter

class InvoiceMinimalSerializer(@Expose var id: String = "", @Expose var customerId: String = "",
        @Expose var amount: Int = Int.MIN_VALUE,
        @Expose @JsonAdapter(StatusAdapter::class) var status: Status = Status.PENDING) {
}