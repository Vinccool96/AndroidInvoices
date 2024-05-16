package com.example.androidinvoices.arch.self

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.SharedPreferences
import android.content.UriMatcher
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri

class SelfPreferences : ContentProvider() {

    private val matcher = UriMatcher(UriMatcher.NO_MATCH).apply {
        addURI(AUTHORITY, "*/*", PREFERENCES)
    }

    /* Always return true, indicating that the provider loaded correctly. */
    override fun onCreate(): Boolean = true

    /* Return no type for MIME type */
    override fun getType(uri: Uri): String? = null

    /* insert() always returns null (no URI) */
    override fun insert(uri: Uri, values: ContentValues?): Uri? = null

    /* delete() always returns "no rows affected" (0) */
    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int = 0

    /* Provide a read only access to the content provider */
    override fun query(uri: Uri, projection: Array<String>?, selection: String?,
            selectionArgs: Array<String>?, sortOrder: String?): Cursor {
        return when (matcher.match(uri)) {
            PREFERENCES -> {
                val key = uri.pathSegments[0]
                val cursor = MatrixCursor(arrayOf(key))
                context?.getSharedPreferences(SelfResolver.TAG, Context.MODE_PRIVATE)?.let {
                    if (!it.contains(key)) {
                        return cursor
                    }

                    cursor.newRow().add(getValue(it, uri, key, uri.pathSegments[1]))
                }
                cursor
            }

            else -> throw IllegalArgumentException("Unsupported uri $uri")
        }
    }

    /* update() always returns "no rows affected" (0) */
    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int = 0

    private fun getValue(sp: SharedPreferences, uri: Uri, key: String, type: String): Any? {
        return when (type) {
            STRING_TYPE -> sp.getString(key, null)
            BOOLEAN_TYPE -> if (sp.getBoolean(key, false)) 1 else 0
            LONG_TYPE -> sp.getLong(key, 0L)
            INT_TYPE -> sp.getInt(key, 0)
            FLOAT_TYPE -> sp.getFloat(key, 0f)
            else -> throw IllegalArgumentException("Unsupported type $uri")
        }
    }

    companion object {

        const val AUTHORITY: String = "com.example.androidinvoices.arch.self.self_provider"

        private const val PREFERENCES = 1

        private const val INT_TYPE = "integer"

        private const val LONG_TYPE = "long"

        private const val FLOAT_TYPE = "float"

        private const val BOOLEAN_TYPE = "boolean"

        private const val STRING_TYPE = "string"

    }

}