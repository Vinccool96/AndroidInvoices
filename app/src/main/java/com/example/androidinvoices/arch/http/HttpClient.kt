package com.example.androidinvoices.arch.http

import com.example.androidinvoices.core.serial.*
import retrofit2.Call
import retrofit2.http.*

interface HttpClient {

    @GET(REVENUES)
    fun getRevenues(): Call<List<RevenueSerializer>>

    @GET("$CARDS/$DATA")
    fun getCardData(): Call<CardSerializer>

    @GET(CUSTOMERS)
    fun getCustomers(): Call<List<CustomerMinimalSerializer>>

    @GET("$CUSTOMERS/$FILTERED")
    fun getCustomersFiltered(@Query(FILTER) filter: String?): Call<FilteredCustomerSerializer>

    @GET("$INVOICES/$LATEST")
    fun getLatestInvoices(): Call<InvoiceSerializer>

    @GET("$INVOICES/$FILTERED")
    fun getInvoicesFiltered(): Call<InvoiceSerializer>

    @GET("$INVOICES/$PAGE")
    fun getInvoicesFilteredPage(): Call<Int>

    @GET("$INVOICES/$ID_PARAM")
    fun getInvoice(@Path(ID) id: String): Call<InvoiceMinimalSerializer>

    @POST(CUSTOMERS)
    fun createInvoice(@Body dto: CreateInvoiceSerializer): Call<InvoiceSerializer>

    @PUT("$INVOICES/$ID_PARAM")
    fun updateInvoice(@Path(ID) id: String, @Body dto: UpdateInvoiceSerializer): Call<InvoiceSerializer>

    @DELETE("$INVOICES/$ID_PARAM")
    fun deleteInvoice(@Path(ID) id: String): Call<InvoiceSerializer>

    companion object {

        private const val ID = "id"

        private const val ID_PARAM = "{$ID}"

        private const val FILTER = "filter"

        private const val FILTERED = "filtered"

        private const val LATEST = "latest"

        private const val PAGE = "page"

        private const val REVENUES = "revenues"

        private const val CARDS = "cards"

        private const val DATA = "data"

        private const val CUSTOMERS = "customers"

        private const val INVOICES = "invoices"

    }

}