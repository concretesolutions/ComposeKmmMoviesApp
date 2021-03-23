package br.com.concrete.composekmmmoviesapp.androidApp

import br.com.concrete.composekmmmoviesapp.MoviesSdk
import br.com.concrete.composekmmmoviesapp.androidApp.data.databaseModule
import br.com.concrete.composekmmmoviesapp.androidApp.data.mapper.FavoritesMapper
import br.com.concrete.composekmmmoviesapp.androidApp.data.mapper.MoviesMapper
import br.com.concrete.composekmmmoviesapp.androidApp.data.networkModule
import br.com.concrete.composekmmmoviesapp.androidApp.home.favoritestab.FavoritesViewModel
import br.com.concrete.composekmmmoviesapp.androidApp.home.moviestab.MoviesViewModel
import br.com.concrete.composekmmmoviesapp.database.DatabaseDriverFactory
import br.com.concrete.composekmmmoviesapp.di.DataDriverManager
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val screenModules = module {
    viewModel {
        MoviesViewModel(get(), get(), get())
    }

    viewModel {
        FavoritesViewModel(get())
    }

    single {
        FavoritesMapper()
    }

    single {
        MoviesMapper()
    }

    single {
        MoviesSdk(DatabaseDriverFactory(androidContext()))
    }
}

val appModules = listOf(
    networkModule, screenModules, databaseModule
)