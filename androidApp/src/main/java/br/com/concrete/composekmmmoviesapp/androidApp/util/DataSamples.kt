package br.com.concrete.composekmmmoviesapp.androidApp.util

import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Genre
import br.com.concrete.composekmmmoviesapp.androidApp.data.model.Movie

object DataSamples {
    val movie = Movie(
        id = 123,
        imageUrl = "https://image.tmdb.org/t/p/w500/rcUcYzGGicDvhDs58uM44tJKB9F.jpg",
        title = "Se Enlouquecer, Não se Apaixone",
        releaseYear = 2010,
        isfavorite = false,
        genres = listOf(Genre(1, "Animação"), Genre(2, "Suspense")),
        overview = "Craig (Keir Gilchrist), estressado com as demandas de" +
                " ser um adolescente e assustado com sua tendência suicida," +
                " decide buscar ajuda em uma clínica psiquiátrica." +
                " Internado por uma semana, ele logo é acolhido por" +
                " Bobby (Zach Galifianakis), que se torna seu mentor," +
                " e se encanta com Noelle (Emma Roberts)"
    )
}