package com.example.androidinvoices.core.serial

import com.example.androidinvoices.core.model.Status
import com.example.androidinvoices.core.model.UpdateInvoiceModel
import com.example.androidinvoices.core.serial.adapter.StatusAdapter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.JsonAdapter

class UpdateInvoiceSerializer(@Expose var customerId: String? = null, @Expose var amount: Int? = null,
        @Expose @JsonAdapter(StatusAdapter::class) var status: Status? = null) {

    fun toModel(): UpdateInvoiceModel {
        return UpdateInvoiceModel(customerId, amount, status)
    }

    companion object {

        fun fromModel(model: UpdateInvoiceModel): UpdateInvoiceSerializer {
            return UpdateInvoiceSerializer(model.customerId, model.amount, model.status)
        }

    }

}