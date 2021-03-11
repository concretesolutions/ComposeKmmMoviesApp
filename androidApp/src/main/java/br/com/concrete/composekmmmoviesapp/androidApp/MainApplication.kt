package br.com.concrete.composekmmmoviesapp.androidApp

import android.app.Application
import br.com.concrete.composekmmmoviesapp.di.androidDi
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule

class MainApplication : Application(), DIAware {
    override val di by DI.lazy {
        import(androidXModule(this@MainApplication))
        importAll(androidDi)
    }
}