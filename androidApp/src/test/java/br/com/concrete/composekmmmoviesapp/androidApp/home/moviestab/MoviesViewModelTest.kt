package br.com.concrete.composekmmmoviesapp.androidApp.home.moviestab

import br.com.concrete.composekmmmoviesapp.androidApp.R
import br.com.concrete.composekmmmoviesapp.androidApp.data.MoviesDbApi
import br.com.concrete.composekmmmoviesapp.androidApp.data.dto.MoviePageDto
import br.com.concrete.composekmmmoviesapp.androidApp.data.mapper.MoviesMapper
import br.com.concrete.composekmmmoviesapp.androidApp.util.CoroutineTestRule
import io.mockk.coEvery
import io.mockk.mockk
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

class MoviesViewModelTest {
    @get:Rule
    val instantRule = CoroutineTestRule()

    private val apiMock = mockk<MoviesDbApi>()
    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setup() {
        viewModel = MoviesViewModel(apiMock, MoviesMapper())
    }

    @Test
    fun givenSuccessfulRequest_shouldEmitSuccessStateWithList() {
        coEvery {
            apiMock.getPopularMovies()
        } returns Response.success(MoviePageDto(1, emptyList()))

        viewModel.moviesList.observeForever {
            assertEquals(MoviesListUiState.Success(emptyList()), viewModel.moviesList.value)
        }
    }

    @Test
    fun givenErrorRequest_shouldEmitErrorState() {
        coEvery {
            apiMock.getPopularMovies()
        } returns Response.error(404, "".toResponseBody())

        viewModel.moviesList.observeForever {
            assertEquals(
                MoviesListUiState.Error(R.string.generic_error),
                viewModel.moviesList.value
            )
        }
    }
}