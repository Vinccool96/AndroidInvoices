package com.example.androidinvoices.arch.bind

import com.example.androidinvoices.arch.http.HttpBuilder
import com.example.androidinvoices.arch.http.HttpClient
import com.example.androidinvoices.arch.self.SelfShared
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class BindBackend {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val builder = GsonBuilder().apply {
            excludeFieldsWithoutExposeAnnotation()
        }

        return builder.create()
    }

    @Provides
    @Singleton
    fun provideConverter(gson: Gson): Converter.Factory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    fun provideHttpBuilder(): HttpBuilder {
        return HttpBuilder()
    }

    @Provides
    @Singleton
    fun provideBuilder(factory: Converter.Factory, httpBuilder: HttpBuilder, self: SelfShared): Retrofit.Builder {
        return Retrofit.Builder().client(httpBuilder.build(self)).addConverterFactory(factory)
    }

    @Provides
    @Singleton
    fun provideClient(builder: Retrofit.Builder): HttpClient {
        return builder.baseUrl(BASE).build().create(HttpClient::class.java)
    }

    companion object {

        private const val BASE = "http://localhost:3001"

    }

}