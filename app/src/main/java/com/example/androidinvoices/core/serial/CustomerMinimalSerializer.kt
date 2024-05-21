package com.example.androidinvoices.core.serial

import com.google.gson.annotations.Expose

class CustomerMinimalSerializer(@Expose var id: String = "", @Expose var name: String = "") {

    companion object {}

}