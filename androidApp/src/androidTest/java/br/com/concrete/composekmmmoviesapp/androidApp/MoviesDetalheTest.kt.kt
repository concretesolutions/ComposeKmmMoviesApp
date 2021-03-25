package br.com.concrete.composekmmmoviesapp.androidApp

import android.util.Log
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.concrete.composekmmmoviesapp.androidApp.util.*
import br.com.concrete.composekmmmoviesapp.androidApp.utils.MockWebServerRule
import br.com.concrete.composekmmmoviesapp.androidApp.utils.loadAsFixture
import br.com.concrete.composekmmmoviesapp.androidApp.utils.retryer
import okhttp3.mockwebserver.MockResponse
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
class MoviesDetalheTest {
    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @get:Rule
    val mockWebServerRule = MockWebServerRule()

    fun enqueueResponse(responseFileName: String) {
        val file = responseFileName.loadAsFixture()
        Log.d("AppMovie", "File:$file")
        mockWebServerRule.mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(file))
    }

    fun enqueueResponseError() {
        mockWebServerRule.mockWebServer.enqueue(MockResponse().setResponseCode(400))
    }

    @Before
    fun setup() {

        composeRule.setContent {
            MoviesApp()
        }
    }

    /*
    Quando clico em um item da lista de filmes, consigo ver o detalhe do mesmo filme?*/
    @Test
    fun givenInitialState_whenCardMovieIsClicked_shouldShowDetalhesFilmes(){
        enqueueResponse("response_movies_success.json")
        enqueueResponse("response_gender_success.json")
        retryer {
            composeRule.onNode(hasTestTag(SCREEN_MOVIES)).assertIsDisplayed()
            composeRule.onNode(hasTestTag(COMPONENT_LIST_MOVIES)).assertExists()

           composeRule.onNode(hasTestTag(COMPONENT_ITEM_MOVIES)).performClick()

        //   composeRule.onNode(hasTestTag(SCREEN_DETAILS)).assertIsDisplayed()
        }


    }
}