package br.com.concrete.composekmmmoviesapp.androidApp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MoviesApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MoviesApplication)

            modules(appModules)
        }
    }
}