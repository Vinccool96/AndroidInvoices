package com.example.androidinvoices.arch.bind

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, BindBackend::class])
interface BindComponent {

    fun inject(target: AndroidInvoicesApplication)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Context): BindComponent

    }

}