package com.example.kodein_r8

import android.app.Application
import android.util.Log
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class KodeinApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein {
        singleton {
            ProviderImpl()
        }.also {
            bind<Provider>() with it
            bind<ManagedProvider>() with it
        }
    }

    private val provider by instance<Provider>()
    private val managedProvider by instance<ManagedProvider>()

    override fun onCreate() {
        super.onCreate()

        Log.i(this::class.simpleName, provider::class.simpleName)
        Log.i(this::class.simpleName, managedProvider::class.simpleName)
    }
}