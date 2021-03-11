package br.com.concrete.composekmmmoviesapp.di

import android.content.Context
import br.com.concrete.composekmmmoviesapp.database.DatabaseDriverFactory
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
val androidDi = DI.Module(name = "Android") {
    importAll(sharedDi)
//    bind<DatabaseDriverFactory>() with provider { DatabaseDriverFactory(instance<Context>()) }
}
