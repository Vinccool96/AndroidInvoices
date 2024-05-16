package com.example.androidinvoices.arch.self

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.net.Uri

class SelfResolver(context: Context, private val authority: String) {

    private val resolver: ContentResolver = context.contentResolver

    private fun getContentUri(key: String, type: String): Uri {
        val content = "content://$authority"
        return Uri.parse(content).buildUpon().appendPath(key).appendPath(type).build()
    }

    private fun getStringValue(cursor: Cursor?, def: String): String {
        if (cursor == null) return def
        var value = def
        if (cursor.moveToFirst()) value = cursor.getString(0)
        cursor.close()
        return value
    }

    private fun getBooleanValue(cursor: Cursor?, def: Boolean): Boolean {
        if (cursor == null) return def
        var value = def
        if (cursor.moveToFirst()) value = cursor.getInt(0) > 0
        cursor.close()
        return value
    }

    private fun getIntValue(cursor: Cursor?, def: Int): Int {
        if (cursor == null) return def
        var value = def
        if (cursor.moveToFirst()) value = cursor.getInt(0)
        cursor.close()
        return value
    }

    private fun getLongValue(cursor: Cursor?, def: Long): Long {
        if (cursor == null) return def
        var value = def
        if (cursor.moveToFirst()) value = cursor.getLong(0)
        cursor.close()
        return value
    }

    /* private fun getFloatValue(cursor: Cursor?, def: Float): Float {
        if (cursor == null) return def
        var value = def
        if (cursor.moveToFirst()) value = cursor.getFloat(0)
        cursor.close()
        return value
    } */

    fun getString(key: String, def: String): String {
        return getStringValue(query(getContentUri(key, STRING_TYPE)), def)
    }

    fun getBoolean(key: String, def: Boolean): Boolean {
        return getBooleanValue(query(getContentUri(key, BOOLEAN_TYPE)), def)
    }

    fun getInt(key: String, def: Int): Int {
        return getIntValue(query(getContentUri(key, INT_TYPE)), def)
    }

    fun getLong(key: String, def: Long): Long {
        return getLongValue(query(getContentUri(key, LONG_TYPE)), def)
    }

    private fun query(uri: Uri): Cursor? {
        return resolver.query(uri, null, null, null, null)
    }

    companion object {

        val TAG: String = SelfResolver::class.java.simpleName

        const val INT_TYPE = "integer"

        const val LONG_TYPE = "long"

        const val BOOLEAN_TYPE = "boolean"

        const val STRING_TYPE = "string"

    }

}