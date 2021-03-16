package br.com.concrete.composekmmmoviesapp.androidApp.home.moviestab

import br.com.concrete.composekmmmoviesapp.androidApp.R
import br.com.concrete.composekmmmoviesapp.androidApp.data.MovieDbRepository
import br.com.concrete.composekmmmoviesapp.androidApp.data.MoviesDbApi
import br.com.concrete.composekmmmoviesapp.androidApp.data.apidto.GenreDto
import br.com.concrete.composekmmmoviesapp.androidApp.data.apidto.MoviePageDto
import br.com.concrete.composekmmmoviesapp.androidApp.data.db.FavoriteMovieDbDao
import br.com.concrete.composekmmmoviesapp.androidApp.data.mapper.FavoritesMapper
import br.com.concrete.composekmmmoviesapp.androidApp.data.mapper.MoviesMapper
import br.com.concrete.composekmmmoviesapp.androidApp.util.CoroutineTestRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class MoviesViewModelTest {
    @get:Rule
    val instantRule = CoroutineTestRule()

    private val mockApi = mockk<MoviesDbApi>()
    private val mockFavoritesDao = mockk<FavoriteMovieDbDao>()
    private val repo = MovieDbRepository(
        api = mockApi,
        mapper = MoviesMapper(),
        favoriteDao = mockFavoritesDao,
        favoritesMapper = FavoritesMapper(),
        instantRule.testDispatcher
    )
    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setup() {
        viewModel = MoviesViewModel(repo)
        coEvery {
            mockFavoritesDao.getFavoriteMovies()
        } returns emptyList()

        coEvery {
            mockApi.getGenres()
        } returns Response.success(GenreDto(emptyList()))
    }

    @Test
    fun givenSuccessfulRequest_shouldEmitSuccessStateWithList() {
        coEvery {
            mockApi.getPopularMovies()
        } returns Response.success(MoviePageDto(1, emptyList()))

        assertEquals(MoviesListUiState.Success(emptyList()), viewModel.moviesList.value)
    }

    @Test
    fun givenErrorRequest_shouldEmitErrorState() {
        coEvery {
            repo.getPopularMovies()
        } throws IllegalStateException()

        assertEquals(
            MoviesListUiState.Error(R.string.generic_error),
            viewModel.moviesList.value
        )
    }
}
