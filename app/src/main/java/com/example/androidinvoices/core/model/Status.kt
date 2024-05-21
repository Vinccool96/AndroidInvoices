package com.example.androidinvoices.core.model

enum class Status {

    PAID,

    PENDING;

    override fun toString(): String {
        return name.lowercase()
    }

    companion object {

        fun fromString(string: String): Status {
            return when (string) {
                "paid" -> PAID
                "pending" -> PENDING
                else -> throw IllegalArgumentException("Wrong value for parameter string. " +
                        "Expected either \"paid\" or \"pending\", received $string")
            }
        }

    }

}