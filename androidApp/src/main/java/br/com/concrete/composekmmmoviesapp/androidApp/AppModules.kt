package br.com.concrete.composekmmmoviesapp.androidApp

import br.com.concrete.composekmmmoviesapp.androidApp.data.mapper.MoviesMapper
import br.com.concrete.composekmmmoviesapp.androidApp.home.moviestab.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val screenModules = module {
    viewModel {
        MoviesViewModel(get(), get())
    }

    single {
        MoviesMapper()
    }
}