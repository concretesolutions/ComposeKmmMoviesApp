package br.com.concrete.composekmmmoviesapp

import br.com.concrete.composekmmmoviesapp.data.Response
import br.com.concrete.composekmmmoviesapp.di.di
import br.com.concrete.composekmmmoviesapp.domain.Genres
import br.com.concrete.composekmmmoviesapp.domain.Movies
import br.com.concrete.composekmmmoviesapp.repository.GenreRepository
import br.com.concrete.composekmmmoviesapp.repository.MovieRepository
import org.kodein.di.instance
import org.kodein.di.newInstance

class MoviesSdk {

    private val movieRepository by di.newInstance { MovieRepository(instance()) }
    private val genreRepository by di.newInstance { GenreRepository(instance()) }

    suspend fun getPopularMovies() : Response<Movies> {
        return  movieRepository.getPopularMovies()
    }

    suspend fun getGenresList() : Response<Genres>{
        return genreRepository.getGenresList()
    }

    suspend fun saveMovie(){
        TODO()
    }
    suspend fun unsaveMovie(){
        TODO()
    }

    suspend fun getFavoriteMovies(){
        TODO()
    }
    suspend fun findMovie(){
        TODO()
    }
}