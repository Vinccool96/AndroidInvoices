package com.example.androidinvoices.core.serial

import com.google.gson.annotations.Expose

class CardSerializer(@Expose var numberOfCustomers: Int = Int.MIN_VALUE,
        @Expose var numberOfInvoices: Int = Int.MIN_VALUE, @Expose var totalPaidInvoices: String = "",
        @Expose var totalPendingInvoices: String = "") {

    companion object {}

}