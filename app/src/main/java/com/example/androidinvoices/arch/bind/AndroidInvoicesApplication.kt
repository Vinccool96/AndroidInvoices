package com.example.androidinvoices.arch.bind

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class AndroidInvoicesApplication : Application(), HasAndroidInjector {

    override fun onCreate() {
        super.onCreate()
        ourComponent = DaggerBindComponent.factory().create(this)
        ourComponent.inject(this)
    }

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return injector
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {

        lateinit var ourComponent: BindComponent

    }

}