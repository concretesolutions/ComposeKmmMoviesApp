package br.com.concrete.composekmmmoviesapp.androidApp.popularMovie

import br.com.concrete.composekmmmoviesapp.androidApp.R


class MovieDao constructor(val name:String, val moviePicture:Int){
    companion object{
        fun getMovies():List<MovieDao>{
            return arrayListOf(
                MovieDao("HEROI", R.drawable.ic_banner_movie),
                MovieDao("HEROI", R.drawable.ic_banner_movie),
                MovieDao("HEROI", R.drawable.ic_banner_movie),
                MovieDao("HEROI", R.drawable.ic_banner_movie),
                MovieDao("HEROI", R.drawable.ic_banner_movie),
                MovieDao("HEROI", R.drawable.ic_banner_movie),
                MovieDao("HEROI", R.drawable.ic_banner_movie),
                MovieDao("HEROI", R.drawable.ic_banner_movie),
                MovieDao("HEROI", R.drawable.ic_banner_movie),
                MovieDao("HEROI", R.drawable.ic_banner_movie),
                MovieDao("HEROI", R.drawable.ic_banner_movie),
                MovieDao("HEROI", R.drawable.ic_banner_movie),
                MovieDao("HEROI", R.drawable.ic_banner_movie),
                MovieDao("HEROI", R.drawable.ic_banner_movie),
                MovieDao("HEROI", R.drawable.ic_banner_movie),
                MovieDao("HEROI", R.drawable.ic_banner_movie),
                MovieDao("HEROI", R.drawable.ic_banner_movie),
                MovieDao("HEROI", R.drawable.ic_banner_movie),
                MovieDao("HEROI", R.drawable.ic_banner_movie),
                MovieDao("HEROI", R.drawable.ic_banner_movie)


            ).toList()
        }

    }

}
