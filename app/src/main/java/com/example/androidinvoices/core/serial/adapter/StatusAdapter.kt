package com.example.androidinvoices.core.serial.adapter

import com.example.androidinvoices.core.model.Status
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

class StatusAdapter : TypeAdapter<Status>() {

    override fun read(reader: JsonReader): Status {
        return Status.fromString(reader.nextString())
    }

    override fun write(out: JsonWriter?, value: Status?) {
        value ?: return
        out?.value(value.toString())
    }

}