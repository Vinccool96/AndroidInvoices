package com.example.androidinvoices.core.serial

import com.example.androidinvoices.core.model.CustomerMinimalModel
import com.google.gson.annotations.Expose

class CustomerMinimalSerializer(@Expose var id: String = "", @Expose var name: String = "") {

    fun toModel(): CustomerMinimalModel {
        return CustomerMinimalModel(id, name)
    }

}