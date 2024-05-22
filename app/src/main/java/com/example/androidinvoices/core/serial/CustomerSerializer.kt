package com.example.androidinvoices.core.serial

import com.example.androidinvoices.core.model.CustomerModel
import com.google.gson.annotations.Expose

class CustomerSerializer(@Expose var id: String = "", @Expose var name: String = "", @Expose var email: String = "",
        @Expose var imageUrl: String = "") {

    fun toModel(): CustomerModel {
        return CustomerModel(id, name, email, imageUrl)
    }

}