package com.example.androidinvoices.core.serial

import com.google.gson.annotations.Expose

class CustomerSerializer(@Expose var id: String = "", @Expose var name: String = "", @Expose var email: String = "",
        @Expose var imageUrl: String = "") {

    companion object {}

}