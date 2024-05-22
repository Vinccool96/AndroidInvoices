package com.example.androidinvoices.core.model

import java.util.Date

class InvoiceModel(var id: String, var customer: CustomerModel, var customerId: String, var amount: Int,
        var status: Status, var date: Date) {
}