package com.example.androidinvoices.core.serial

import com.google.gson.annotations.Expose

class RevenueSerializer(@Expose var month: String = "", @Expose var revenue: Int = Int.MIN_VALUE) {

    companion object {}

}