package com.example.androidinvoices.core.serial.adapter

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateAdapter : TypeAdapter<Date>() {

    override fun read(reader: JsonReader?): Date {
        reader ?: throw IllegalArgumentException("reader is null")

        return SimpleDateFormat(PATTERN, Locale.ENGLISH).parse(reader.nextString())!!
    }

    override fun write(out: JsonWriter?, value: Date?) {
        value ?: return

        out?.value(SimpleDateFormat(PATTERN, Locale.ENGLISH).format(value))
    }

    companion object {

        private const val PATTERN = "yyyy-MM-dd"

    }

}