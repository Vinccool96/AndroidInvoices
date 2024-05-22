package com.example.androidinvoices.core.serial

import com.example.androidinvoices.core.model.FilteredCustomerModel
import com.google.gson.annotations.Expose

class FilteredCustomerSerializer(@Expose var id: String = "", @Expose var name: String = "",
        @Expose var email: String = "", @Expose var imageUrl: String = "",
        @Expose var totalInvoices: Int = Int.MIN_VALUE, @Expose var totalPaid: String = "",
        @Expose var totalPending: String = "") {

    fun toModel(): FilteredCustomerModel {
        return FilteredCustomerModel(id, name, email, imageUrl, totalInvoices, totalPaid, totalPending)
    }

}