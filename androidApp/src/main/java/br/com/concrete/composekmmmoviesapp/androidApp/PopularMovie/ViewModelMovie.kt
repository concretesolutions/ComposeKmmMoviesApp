package br.com.concrete.composekmmmoviesapp.androidApp.PopularMovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.concrete.composekmmmoviesapp.androidApp.R

class ViewModelMovie: ViewModel() {
        val movieList:MutableLiveData<List<MovieData>> by lazy {
            MutableLiveData<List<MovieData>>()
        }
        private  var listaMovie :ArrayList<MovieData> = ArrayList()

    init {
        getDogList()
        }
        fun getDogList(){
            fechList()
            movieList.value = listaMovie
        }
        private fun fechList(){
            for(i in 1..5){
                listaMovie.add(MovieData(R.drawable.ic_banner_movie,"Interstellar"))
                listaMovie.add(MovieData(R.drawable.ic_banner_movie,"Interstellar"))
                listaMovie.add(MovieData(R.drawable.ic_banner_movie,"Interstellar"))
                listaMovie.add(MovieData(R.drawable.ic_banner_movie,"Interstellar"))
                listaMovie.add(MovieData(R.drawable.ic_banner_movie,"Interstellar"))
                listaMovie.add(MovieData(R.drawable.ic_banner_movie,"Interstellar"))
        }
    }
}