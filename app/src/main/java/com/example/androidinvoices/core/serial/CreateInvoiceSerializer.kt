package com.example.androidinvoices.core.serial

import com.example.androidinvoices.core.model.CreateInvoiceModel
import com.example.androidinvoices.core.model.Status
import com.example.androidinvoices.core.serial.adapter.StatusAdapter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.JsonAdapter

class CreateInvoiceSerializer(@Expose var customerId: String = "", @Expose var amount: Int = Int.MIN_VALUE,
        @Expose @JsonAdapter(StatusAdapter::class) var status: Status = Status.PENDING) {

    fun toModel(): CreateInvoiceModel {
        return CreateInvoiceModel(customerId, amount, status)
    }

    companion object {

        fun fromModel(model: CreateInvoiceModel): CreateInvoiceSerializer {
            return CreateInvoiceSerializer(model.customerId, model.amount, model.status)
        }

    }

}