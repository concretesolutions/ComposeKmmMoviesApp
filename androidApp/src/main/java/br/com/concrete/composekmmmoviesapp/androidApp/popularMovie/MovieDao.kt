package br.com.concrete.composekmmmoviesapp.androidApp.popularMovie

import br.com.concrete.composekmmmoviesapp.androidApp.R


class MovieDao(val name:String, val moviePicture: String){
    companion object{
        fun getMovies():List<MovieDao>{
            return arrayListOf(
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg"),
                MovieDao("HEROI", "https://pics.filmaffinity.com/interstellar-366875261-large.jpg")


            ).toList()
        }

    }

}
