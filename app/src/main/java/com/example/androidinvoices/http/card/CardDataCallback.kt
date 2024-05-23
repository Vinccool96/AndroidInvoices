package com.example.androidinvoices.http.card

import com.example.androidinvoices.arch.http.HttpCallback
import com.example.androidinvoices.arch.http.HttpClient
import com.example.androidinvoices.arch.http.HttpListener
import com.example.androidinvoices.core.model.CardModel
import com.example.androidinvoices.core.serial.CardSerializer

class CardDataCallback(private val listener: HttpListener<CardModel>, private val http: HttpClient): HttpCallback<CardSerializer>(false) {

    override fun onSuccess(serialized: CardSerializer) {
        listener.onSuccess(serialized.toModel())
    }

    fun execute() {
        add(http.getCardData()).enqueue(this)
    }

}