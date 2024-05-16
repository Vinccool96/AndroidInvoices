package com.example.androidinvoices.arch.bind

import com.example.androidinvoices.arch.http.HttpBuilder
import com.example.androidinvoices.arch.http.HttpClient
import com.example.androidinvoices.arch.self.SelfShared
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
    fun provideConverter(): Converter.Factory {
        return GsonConverterFactory.create()
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