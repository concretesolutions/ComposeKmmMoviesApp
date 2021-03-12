package br.com.concrete.composekmmmoviesapp.androidApp.home.moviestab

import br.com.concrete.composekmmmoviesapp.androidApp.R
import br.com.concrete.composekmmmoviesapp.androidApp.data.MovieDbRepository
import br.com.concrete.composekmmmoviesapp.androidApp.util.CoroutineTestRule
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test

class MoviesViewModelTest {
    @get:Rule
    val instantRule = CoroutineTestRule()

    private val mockRepo = mockk<MovieDbRepository>()
    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setup() {
        viewModel = MoviesViewModel(mockRepo)
    }

    @Ignore("Migrate to repo")
    @Test
    fun givenSuccessfulRequest_shouldEmitSuccessStateWithList() {
        coEvery {
            mockRepo.getPopularMovies()
        } returns emptyList()

        viewModel.moviesList.observeForever {}

        assertEquals(MoviesListUiState.Success(emptyList()), viewModel.moviesList.value)
    }

    @Ignore("Migrate to repo")
    @Test
    fun givenErrorRequest_shouldEmitErrorState() {
        coEvery {
            mockRepo.getPopularMovies()
        } throws IllegalStateException()

        viewModel.moviesList.observeForever {
            assertEquals(
                MoviesListUiState.Error(R.string.generic_error),
                viewModel.moviesList.value
            )
        }
    }
}