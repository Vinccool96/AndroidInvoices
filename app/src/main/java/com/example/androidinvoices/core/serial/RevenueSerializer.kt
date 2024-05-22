package com.example.androidinvoices.core.serial

import com.example.androidinvoices.core.model.RevenueModel
import com.google.gson.annotations.Expose

class RevenueSerializer(@Expose var month: String = "", @Expose var revenue: Int = Int.MIN_VALUE) {

    fun toModel(): RevenueModel {
        return RevenueModel(month, revenue)
    }

}